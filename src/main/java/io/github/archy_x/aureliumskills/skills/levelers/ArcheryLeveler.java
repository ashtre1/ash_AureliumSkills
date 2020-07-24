package io.github.archy_x.aureliumskills.skills.levelers;

import io.github.archy_x.aureliumskills.AureliumSkills;
import io.github.archy_x.aureliumskills.Options;
import io.github.archy_x.aureliumskills.skills.Skill;
import io.github.archy_x.aureliumskills.skills.Source;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class ArcheryLeveler implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDeath(EntityDeathEvent event) {
		if (Options.isEnabled(Skill.ARCHERY)) {
			LivingEntity e = event.getEntity();
			//Checks if in blocked region
			if (AureliumSkills.worldGuardEnabled) {
				if (AureliumSkills.worldGuardSupport.isInBlockedRegion(e.getLocation())) {
					return;
				}
			}
			if (e.getKiller() != null) {
				if (e.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
					EntityDamageByEntityEvent ee = (EntityDamageByEntityEvent) e.getLastDamageCause();
					if (ee.getDamager() instanceof Arrow) {
						EntityType type = e.getType();
						Player p = (Player) e.getKiller();
						Skill s = Skill.ARCHERY;
						if (type.equals(EntityType.CHICKEN) || type.equals(EntityType.BAT) || type.equals(EntityType.OCELOT) || type.equals(EntityType.RABBIT)) {
							Leveler.addXp(p, s, Source.ARCHERY_SMALL_PASSIVE);
						}
						else if (type.equals(EntityType.COW) || type.equals(EntityType.PIG) || type.equals(EntityType.SHEEP) || type.equals(EntityType.MUSHROOM_COW) ||
								type.equals(EntityType.SQUID) || type.equals(EntityType.HORSE) || type.equals(EntityType.SNOWMAN) || type.equals(EntityType.MULE) ||
								type.equals(EntityType.DONKEY) || type.equals(EntityType.HORSE) || type.equals(EntityType.SNOWMAN) || type.equals(EntityType.PARROT)) {
							Leveler.addXp(p, s, Source.ARCHERY_PASSIVE);
						}
						else if (type.equals(EntityType.LLAMA) || type.equals(EntityType.WOLF) || type.equals(EntityType.SILVERFISH) || type.equals(EntityType.ENDERMITE)) {
							Leveler.addXp(p, s, Source.ARCHERY_WEAK_HOSTILE);
						}
						else if (type.equals(EntityType.ZOMBIE) || type.equals(EntityType.SKELETON) || type.equals(EntityType.SPIDER) || type.equals(EntityType.ZOMBIE_VILLAGER)) {
							Leveler.addXp(p, s, Source.ARCHERY_COMMON_HOSTILE);
						}
						else if (type.equals(EntityType.CREEPER) || type.equals(EntityType.STRAY) || type.equals(EntityType.HUSK) || type.equals(EntityType.CAVE_SPIDER) ||
								type.equals(EntityType.SLIME) || type.equals(EntityType.MAGMA_CUBE) || type.equals(EntityType.VEX) || type.equals(EntityType.GUARDIAN)) {
							Leveler.addXp(p, s, Source.ARCHERY_UNCOMMON_HOSTILE);
						}
						else if (type.equals(EntityType.GHAST) || type.equals(EntityType.BLAZE) || type.equals(EntityType.ENDERMAN) || type.equals(EntityType.WITCH)) {
							Leveler.addXp(p, s, Source.ARCHERY_STRONG_HOSTILE);
						}
						else if (type.equals(EntityType.WITHER_SKELETON) || type.equals(EntityType.VINDICATOR) || type.equals(EntityType.POLAR_BEAR) || 
								type.equals(EntityType.SHULKER) || type.equals(EntityType.IRON_GOLEM)) {
							Leveler.addXp(p, s, Source.ARCHERY_STRONGER_HOSTILE);
						}
						else if (type.equals(EntityType.ELDER_GUARDIAN) || type.equals(EntityType.EVOKER)) {
							Leveler.addXp(p, s, Source.ARCHERY_MINI_BOSS);
						}
						else if (type.equals(EntityType.WITHER) || type.equals(EntityType.ENDER_DRAGON)) {
							Leveler.addXp(p, s, Source.ARCHERY_BOSS);
						}
					}
				}
			}
		}
	}
}
