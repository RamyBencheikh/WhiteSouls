/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumables.repair;

import consumables.Consumable;
import lsg.weapons.Weapon;


public class RepairKit extends Consumable {
    public RepairKit()
    {
        super("Repair Kit", 10, Weapon.DURABILITY_STAT_STRING);
    }

    public int use()
    {
      int cap = this.getCapacity() - 1;
      this.setCapacity(cap);
      return 1;
    }
}
