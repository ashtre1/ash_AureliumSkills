package io.github.archy_x.aureliumskills.skills.levelers;

import io.github.archy_x.aureliumskills.AureliumSkills;
import io.github.archy_x.aureliumskills.Options;
import io.github.archy_x.aureliumskills.skills.Skill;
import io.github.archy_x.aureliumskills.skills.Source;
import io.github.archy_x.aureliumskills.skills.abilities.ForagingAbilities;
import io.github.archy_x.aureliumskills.util.XMaterial;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ForagingLeveler implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBlockBreak(BlockBreakEvent event) {
		if (Options.isEnabled(Skill.FORAGING)) {
			if (event.isCancelled() == false) {
				//Checks if in blocked region
				if (AureliumSkills.worldGuardEnabled) {
					if (AureliumSkills.worldGuardSupport.isInBlockedRegion(event.getBlock().getLocation())) {
						return;
					}
				}
				if (!event.getBlock().hasMetadata("skillsPlaced")) {
					Player p = event.getPlayer();
					Block b = event.getBlock();
					Skill s = Skill.FORAGING;
					Material mat = event.getBlock().getType();
					//If 1.13+
					if (XMaterial.isNewVersion()) {
						if (mat.equals(XMaterial.OAK_LOG.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.OAK_LOG));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.SPRUCE_LOG.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.SPRUCE_LOG));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.BIRCH_LOG.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.BIRCH_LOG));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.JUNGLE_LOG.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.JUNGLE_LOG));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.ACACIA_LOG.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.ACACIA_LOG));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.DARK_OAK_LOG.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.DARK_OAK_LOG));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.OAK_LEAVES.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.OAK_LEAVES));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.SPRUCE_LEAVES.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.SPRUCE_LEAVES));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.BIRCH_LEAVES.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.BIRCH_LEAVES));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.JUNGLE_LEAVES.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.JUNGLE_LEAVES));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.ACACIA_LEAVES.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.ACACIA_LEAVES));
							applyAbilities(p, b);
						}
						else if (mat.equals(XMaterial.DARK_OAK_LEAVES.parseMaterial())) {
							Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.DARK_OAK_LEAVES));
							applyAbilities(p, b);
						}
					}
					//If legacy version (1.12)
					else {
						//If legacy material LOG
						if (mat.equals(XMaterial.OAK_LOG.parseMaterial())) {
							switch(event.getBlock().getData()) {
								case 0:
									Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.OAK_LOG));
									applyAbilities(p, b);
									break;
								case 1:
									Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.SPRUCE_LOG));
									applyAbilities(p, b);
									break;
								case 2:
									Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.BIRCH_LOG));
									applyAbilities(p, b);
									break;
								case 3:
									Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.JUNGLE_LOG));
									applyAbilities(p, b);
									break;
							}
						}
						//If legacy material LOG_2
						else if (mat.equals(XMaterial.ACACIA_LOG.parseMaterial())) {
							switch(event.getBlock().getData()) {
								case 0:
									Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.ACACIA_LOG));
									applyAbilities(p, b);
									break;
								case 1:
									Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.DARK_OAK_LOG));
									applyAbilities(p, b);
									break;
							}
						}
						//If legacy material LEAVES
						else if (mat.equals(XMaterial.OAK_LEAVES.parseMaterial())) {
							byte data = event.getBlock().getData();
							if (data == 0 || data == 8) {
								Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.OAK_LEAVES));
								applyAbilities(p, b);
							}
							else if (data == 1 || data == 9) {
								Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.SPRUCE_LEAVES));
								applyAbilities(p, b);
							}
							else if (data == 2 || data == 10) {
								Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.BIRCH_LEAVES));
								applyAbilities(p, b);
							}	
							else if (data == 3 || data == 11) {
								Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.JUNGLE_LEAVES));
								applyAbilities(p, b);
							}	
						}
						//If legacy material LEAVES_2
						else if (mat.equals(XMaterial.ACACIA_LEAVES.parseMaterial())) {
							byte data = event.getBlock().getData();
							if (data == 0 || data == 8) {
								Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.ACACIA_LEAVES));
								applyAbilities(p, b);
							}
							else if (data == 1 || data == 9) {
								Leveler.addXp(p, s, ForagingAbilities.getModifiedXp(p, Source.DARK_OAK_LEAVES));
								applyAbilities(p, b);
							}
						}
					}
				}
			}
		}
	}
	
	private void applyAbilities(Player p, Block b) {
		ForagingAbilities.lumberjack(p, b);
	}
}
