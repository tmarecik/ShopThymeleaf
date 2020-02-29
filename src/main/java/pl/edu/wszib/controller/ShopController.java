package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.dao.ProductDao;
import pl.edu.wszib.domain.Product;

@Controller                                    /* punkt wejsciowy do naszej alpikacji */
public class ShopController {

    @Autowired                              //wstrzykuje productDao
    private ProductDao productDao;

    @GetMapping                                /* te petoda przechwytuje zadania typu get bez zdef scieżki aplikuje do sciezki domyslnej*/
    public String wetcome(){
        return "welcome";                      //poniewaz mamy theamleaf'a podspodem musimy zwracac nazwy widokow !! themlif przechwytuje je pod spodem
    }

    @GetMapping("shipping")
    public String shipping(Model model){      //umożliwia przekazywanie danych do nowego szablonu
        model.addAttribute("shippingMethodName1", "Paczkomat");             //dwefiniuje pola i wartości w szablonie shipping!!!! do których bedziemy sie odwoływać
        model.addAttribute("shippingMethodName2", "Kurier -przedpłata");
        model.addAttribute("shippingMethodName3", "Kurier -pobranie");
        model.addAttribute("shippingMethodPrice1", 10.50);
        model.addAttribute("shippingMethodPrice2", 15.00);
        model.addAttribute("shippingMethodPrice3", 20.20);
        return "shipping";
    }

    @GetMapping("products")
    public String products(Model model){
        model.addAttribute("products", productDao.getProducts());
        return "products";
    }

    @GetMapping("products/remove/{id}")
    public String remove(@PathVariable Long id){
        productDao.removeProduct(id);
        return "redirect:/products";
    }

    @GetMapping("products/new")
    public String newProducts(Model model){
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("products/save")
    public String saveProduct(Product product){
        productDao.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("products/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model){
        Product product = productDao.getById(id);
        model.addAttribute("product", product);
        return "product";
    }

}
