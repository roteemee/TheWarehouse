package com.example.TheWareHouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class WarehouseController {

	@Autowired
	private SupplierDAO sd;

	@Autowired
	private BrandDAO bd;

	@Autowired
	private ItemDAO id;
	@Autowired
	private ItemCatDAO icd;
	@Autowired
	private PaymentCardDAO pd;
	@Autowired
	private PurchaseOrderDAO pod;
	@Autowired
	private UserDAO ud;

	@ModelAttribute("user")
	private User userStuff() {
		return new User();
	}
// Common pages--------
	@GetMapping("/") // welcome page
	public String doWork() {
		return "welcomePage";
	}
	@GetMapping("userGetLogin")
	public String userLogin() {

		return "welcomePage";

	}
	// Purchase Order------
			@GetMapping("addPO") // add Item page
			public String addPO(Model i) {
				List<Item> itemlist = id.listItems();

				i.addAttribute("itemlist", itemlist);

				return "addNewPO";
			}

			@PostMapping("addPO") // adding to database
			public String createPO(@ModelAttribute(name = "purchaseOrder") PurchaseOrder po) {
				pod.addpurchaseOrder(po); // adds collated attributes to database as described in DAO
				return "home";
			}

			@GetMapping("showPO") // listing all suppliers
			public String listPOs(Model m) {

				List<PurchaseOrder> polist = pod.listpurchaseOrders();

				m.addAttribute("polist", polist);

				return "listAllPOs";
			}
	
	
	// Items------
		@GetMapping("addItem") // add Item page
		public String addItem(Model b, Model itc, Model s) {
			List<Brand> brandlist = bd.listBrands();

			b.addAttribute("brandlist", brandlist);
			
			List<ItemCat> itemCatList = icd.listItemCats();

			itc.addAttribute("itemCatList", itemCatList);
			List<Supplier> supplierlist = sd.listSuppliers();

			s.addAttribute("supplierlist", supplierlist);

			return "addNewItem";
		}

		@PostMapping("addNewItem") // adding to database
		public String createItem(@ModelAttribute(name = "item") Item i, @RequestParam String shortName ) {
			System.out.println("************** short name is:" + shortName);
			System.out.println("*******************item values:" + i);
			
			
			id.addItem(i); // adds collated attributes to database as described in DAO
			return "adminHome";
		}

		@GetMapping("showItems") // listing all suppliers
		public String listItems(Model m) {

			List<Item> itemlist = id.listItems();

			m.addAttribute("itemlist", itemlist);

			return "listItems";
		}

	// Supplier------
	@GetMapping("addSupplier") // add supplier page
	public String addSupplier() {

		return "addNewSupplier";
	}

	@PostMapping("addNewSupplier") // adding to database
	public String createSupplier(@ModelAttribute(name = "supplier") Supplier s) {
		sd.addSupplier(s); // adds collated attributes to database as described in DAO
		return "adminHome";
	}

	@GetMapping("allSuppliers") // listing all suppliers
	public String listSuppliers(Model m) {

		List<Supplier> supplierlist = sd.listSuppliers();

		m.addAttribute("supplierlist", supplierlist);

		return "listSuppliers";
	}

	// User------
	@GetMapping("addNewUser") // add new user page
	public String createUser() {

		return "addNewUser";
	}

	@PostMapping("addNewUser") // add user details to database
	public String createUser(Model model, @ModelAttribute User u) { // using shortcut to collate all the attributes
		model.addAttribute("u", u);
		ud.addUser(u); // adds collated attributes to database as described in DAO
		return "home";

	}

	@GetMapping("allUsers") // listing all users
	public String listUsers(Model m) {

		List<User> userlist = ud.listUsers();

		m.addAttribute("userlist", userlist);

		return "listAllUsers";
	}

	@PostMapping("dashboard") // user logging in and verification
	public String userLogin(@RequestParam String username, @RequestParam String password, Model model) {
		User u = ud.getUser(username);
		model.addAttribute("u", u);
		if (u.getPassword().equals(password)&& password!=null && username!=null) {
			if (u.getEmail().contains("@fdmgroup.com")) {
				return "adminHome";
			} else {
				return "home";
			}
		} else {

			return "welcomePage";
		}
	}

	// Payment Card  --------
	@GetMapping("addPC") // new payment card form page
	public String addPC() {

		return "addNewPaymentCard";
	}

	@GetMapping("showPC") // list all payment cards
	public String showPC(Model m) {

		List<PaymentCard> paymentCardList = pd.listPaymentCards();

		m.addAttribute("paymentCardList", paymentCardList);

		return "listAllPOs";
	}

	@PostMapping("addNewCard") // add payment card to database
	public String createPC(Model model, @ModelAttribute(name = "payment_card") PaymentCard pc,
			@ModelAttribute(name = "user") User u) {
		pd.addPaymentCard(pc);
		pc.setUser(u);
		return "home";
	}

	// Item Categories ----------
	@GetMapping("addItemCat")
	public String addItemCat(Model m) {

		return "addNewItemCat";
	}

	@GetMapping("showItemCat") // list all item categories
	public String showItemCat(Model m) {

		List<ItemCat> itemCatList = icd.listItemCats();

		m.addAttribute("itemCatList", itemCatList);

		return "listItemCats";
	}

	@PostMapping("addNewItemCat") // add a new item category
	public String createIC(Model model, @ModelAttribute(name = "item_Cat") ItemCat ic) {
		icd.additemCat(ic);
		return "adminHome";
	}

	// Brands -------
	@GetMapping("addBrand")

	public String addBrand() {

		return "addNewBrand";
	}

	@GetMapping("showBrands") // list all brands
	public String showBrand(Model m) {

		List<Brand> brandlist = bd.listBrands();

		m.addAttribute("brandlist", brandlist);

		return "listBrands";
	}

	@PostMapping("addBrand") // add a new brand
	public String createBrand(Model model, @ModelAttribute(name = "brand") Brand brand) {
		model.addAttribute("brand", brand);
		bd.addBrand(brand);
		return "addNewBrand";
	}

}
