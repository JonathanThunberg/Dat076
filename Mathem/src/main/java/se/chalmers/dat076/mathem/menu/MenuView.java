/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Patrik
 */
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

public class MenuView {

    private String category;

    @PostConstruct
    public void init() {
        category = "all";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String s) {
        category = s;
    }
}
