package rs.gaiastudio.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import rs.gaiastudio.model.Candle;
import rs.gaiastudio.repo.CandleRepository;


@Controller
public class AdminController {
	
	private String UPLOAD_FOLDER1 = System.getProperty("user.dir") + "/target/classes/static/assets/images/1/";
	private String UPLOAD_FOLDER2 = System.getProperty("user.dir") + "/target/classes/static/assets/images/2/";
	
	@Autowired
	CandleRepository products;
	
	@GetMapping("/admin-login")
	public String adminLogin() {
		
		return "adminLogin";
	}
	
	@GetMapping("/admin")
	public String adminPage(Model model) {
		
		
		ArrayList<Candle> candles = (ArrayList<Candle>) products.findAll();
		model.addAttribute("candles", candles);
		return "adminPage";
	}
	
	@GetMapping("/admin/add")
	public String addItem(Model model) {
		model.addAttribute("candle", new Candle());
		return "adminAdd";
	}
	
	@PostMapping("/admin/add")
	public String addItem(@ModelAttribute Candle candle, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2) {
		
		try {
			candle.setImageFile1(file1.getBytes());
			candle.setImageFile2(file2.getBytes());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("adding " + candle.toString());
		products.save(candle);
		Path path1 = Paths.get(UPLOAD_FOLDER1 + candle.getType() + ".jpg");
		Path path2 = Paths.get(UPLOAD_FOLDER2 + candle.getType() + ".jpg");
		System.out.println(path1);
        try {
			Files.write(path1, candle.getImageFile1());
			Files.write(path2, candle.getImageFile2());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return "redirect:/admin";
	}
	
	
	@GetMapping("/admin/edit/{id}")
	public String editItem(Model model, @PathVariable int id) {
		
		Optional<Candle> item = products.findById((long) id);
		Candle candle = item.get();
		model.addAttribute("candle", candle);
		
		return "adminEdit";
	}
	
	@PostMapping("/admin/edit/{id}")
	public String editItem(Model model, @PathVariable int id, @ModelAttribute Candle candle) {
		
		Optional<Candle> t = products.findById(candle.getId());
		Candle tmp = t.get();
		products.deleteById(candle.getId());
		products.save(tmp);
		
		return "redirect:/admin";
	}
	
	@PostMapping("/admin/remove/{id}")
	public String removeItem(@PathVariable int id) {
		
		Optional<Candle> t = products.findById((long) id);
		Candle candle = t.get();
		Path path1 = Paths.get(UPLOAD_FOLDER1 + candle.getType() + ".jpg");
		Path path2 = Paths.get(UPLOAD_FOLDER2 + candle.getType() + ".jpg");
		try {
			Files.deleteIfExists(path1);
			Files.deleteIfExists(path2);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		products.deleteById((long) id);
		
		return "redirect:/admin";
	}
	
}
