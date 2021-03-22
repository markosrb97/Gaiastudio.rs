package rs.gaiastudio.web;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import rs.gaiastudio.model.Candle;
import rs.gaiastudio.model.Cart;
import rs.gaiastudio.model.CartItem;
import rs.gaiastudio.model.Contact;
import rs.gaiastudio.model.Customer;
import rs.gaiastudio.model.Order;
import rs.gaiastudio.repo.CandleRepository;


@Controller
public class WebController {
	
	@Autowired
	CandleRepository products;
	
	List<Candle> candles;
	Cart cart;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/")
	public String getHome(Model model, HttpSession session) {
		if(session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
			model.addAttribute("cart", cart);
		}else {
			Cart temp = new Cart();
			model.addAttribute("cart", temp);
		}
		

		
		return "index";
	}
	
	@GetMapping("/order")
	public String getForm(Model model, HttpSession session) {
		
		if(session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
			model.addAttribute("cart", cart);
		}else {
			Cart temp = new Cart();
			model.addAttribute("cart", temp);
		}
		
		model.addAttribute("customer", new Customer());
		return "orderForm";
	}
	
	@PostMapping("/order")
	public String submitOrder(@ModelAttribute Customer customer, Model model, HttpSession session) {
		Order order = new Order(customer);
		//model.addAttribute("order", order);
		
		SimpleMailMessage msg = new SimpleMailMessage();
		//adresa na koju ce da se salje mejl za svaki order
		msg.setTo("janiobrad@gmail.com");
		msg.setSubject("order");
                cart = (Cart) session.getAttribute("cart");
                order.setCandles(cart);
                String result = "";
		msg.setText(order.toString());
		
		mailSender.send(msg);
                
                
                Cart temp = new Cart();
		model.addAttribute("cart", temp);
                
		
		return "tyPage";
	}
	
	@GetMapping("/shop")
	public String getShop(Model model, HttpSession session) {
		
		if(session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
			model.addAttribute("cart", cart);
		}else {
			Cart temp = new Cart();
			model.addAttribute("cart", temp);
		}

		candles = new ArrayList<Candle>();
		candles = products.findAll();
		model.addAttribute("candles", candles);
		
		return "shop";
	}
	
	
	@GetMapping("/shop/product/{id}")
	public String getProduct(@PathVariable long id, Model model, HttpSession session) {
		
		if(session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
			model.addAttribute("cart", cart);
		}else {
			Cart temp = new Cart();
			model.addAttribute("cart", temp);
		}
		
		Optional<Candle> value = products.findById(id);
		Candle candle = value.get();
		model.addAttribute("candle", candle);
		model.addAttribute("item", new CartItem(candle));
		return "product";
	}
	
	
	@GetMapping("/cart")
	public String getCart(Model model, HttpSession session) {
		
		if(session.getAttribute("cart") != null) {
			model.addAttribute("cart", cart);
			return "basket";
		}else {
			return "basketEmpty";
		}
	}
	
	
	@PostMapping("/cart/add-item/{id}")
	public String addToCart(@ModelAttribute CartItem item, Model model, @PathVariable long id, HttpSession session) {
		
		candles = new ArrayList<Candle>();
		candles = products.findAll();
		Candle candle =  candles.get((int) id);
		CartItem candleItem = new CartItem(candle);
		candleItem.setQuantity(item.getQuantity());
		if(session.getAttribute("cart") == null) {
			cart = new Cart();
			cart.addItem(candleItem);
			session.setAttribute("cart", cart);
		}else {
			cart = (Cart) session.getAttribute("cart");
			cart.addItem(candleItem);
			session.setAttribute("cart", cart);
		}
		
		return "redirect:/cart";
	}
	
	@DeleteMapping("/cart/remove-item/{id}")
	public String removeFromCart(Model model, @PathVariable long id, HttpSession session) {
		
		candles = new ArrayList<Candle>();
		candles = products.findAll();
		Candle candle = candles.get((int) id);
		CartItem candleItem = new CartItem(candle);
		if(session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
			cart.removeItem(candleItem);
			session.setAttribute("cart", cart);
                        if(cart.size() < 1){
                            return "redirect:/cart";
                        }
		}
		
		
		return "redirect:/cart";
	}
	
	
	@GetMapping("/contact")
	public String contact(Model model, HttpSession session) {
		if(session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
			model.addAttribute("cart", cart);
		}else {
			Cart temp = new Cart();
			model.addAttribute("cart", temp);
		}
		model.addAttribute("contact", new Contact());
		return "contactForm";
	}
        
        @PostMapping("/contact")
        public String contactPost(@ModelAttribute Contact contact, Model model, HttpSession session){
            
            if(session.getAttribute("cart") != null){
                cart = (Cart) session.getAttribute("cart");
                model.addAttribute("cart", cart);
            }else{
                Cart temp = new Cart();
                model.addAttribute("cart", temp);
            }
            
            /*
            SimpleMailMessage msg = new SimpleMailMessage();
            //adresa na koju ce da se salje mejl za svaki order
            msg.setTo("janiobrad@gmail.com");
            msg.setSubject("contact");  
            msg.setText(contact.toString());
            mailSender.send(msg);
            */
            //System.out.println(contact.toString());
            return "tyPageContact";
            
        }
	
	@GetMapping("/about")
        public String about(Model model, HttpSession session){
            if(session.getAttribute("cart") != null){
                cart = (Cart) session.getAttribute("cart");
                model.addAttribute("cart", cart);
            }else{
                Cart temp = new Cart();
                model.addAttribute("cart", temp);
            }
            
            return "about";
        }
	
}