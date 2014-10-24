/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.ctrl;

import javax.inject.Inject;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.model.ShoppingCart;
import se.chalmers.dat076.mathem.model.entityclasses.Product;
import se.chalmers.dat076.mathem.view.CampaignBB;

/**
 *
 * @author victor_nordh92
 */
public class CampaignCtrl {
    private CampaignBB campaignBB;
    
    @Inject
    private ShoppingCart cart;
    
    @Inject
    public void setCampaignBB(CampaignBB campaignBB) {
        this.campaignBB = campaignBB;
    }
    
    public void buy(Product product) {
        cart.add(new OrderItem(product, campaignBB.getAmount()));
    }
}
