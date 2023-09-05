package trxsh.ontop.scythe.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import trxsh.ontop.scythe.Main;
import trxsh.ontop.scythe.command.ResourceRequest;
import trxsh.ontop.scythe.data.CooldownData;
import trxsh.ontop.scythe.scythebase.Scythe;
import trxsh.ontop.scythe.utility.ScytheUtility;

import java.util.Objects;

public class InteractEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        if (e.getItem() == null)
            return;

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

            ItemStack item = e.getItem();
            Player player = e.getPlayer();

            if (Objects.requireNonNull(item.getItemMeta()).hasDisplayName()) {

                Scythe scythe = ScytheUtility.getScytheByStack(item);

                if (scythe != null && !CooldownData.hasCooldown(player.getUniqueId()) && player.isSneaking()) {

                    scythe.doAbility(player);

                }

            }

        }

    }

}
