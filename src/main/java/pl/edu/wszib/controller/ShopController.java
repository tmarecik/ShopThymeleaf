package pl.edu.wszib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                                    /* punkt wejsciowy do naszej alpikacji */
public class ShopController {

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
    public String products(){
        return "products";
    }

}
