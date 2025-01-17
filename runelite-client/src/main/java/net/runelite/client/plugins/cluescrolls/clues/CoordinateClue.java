/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.cluescrolls.clues;

import com.google.common.collect.ImmutableMap;
import lombok.Data;
import lombok.Getter;
import net.runelite.api.Varbits;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import javax.annotation.Nullable;
import java.awt.*;

@Getter
public class CoordinateClue extends ClueScroll implements TextClueScroll, LocationClueScroll
{
	@Data
	private static class CoordinateClueInfo
	{
		private String directions;
		@Nullable
		private boolean lightRequired;
		private Varbits lightSource;

		CoordinateClueInfo(String directions)
		{
			this.directions = directions;
			this.lightRequired = false;
			this.lightSource = null;
		}

		CoordinateClueInfo(String directions, boolean lightRequired)
		{
			this.directions = directions;
			this.lightRequired = true;
			this.lightSource = null;
		}

		CoordinateClueInfo(String directions, boolean lightRequired, Varbits lightSource)
		{
			this.directions = directions;
			this.lightRequired = lightRequired;
			this.lightSource = lightSource;
		}
	}

	private static final ImmutableMap<WorldPoint, CoordinateClueInfo> CLUES = new ImmutableMap.Builder<WorldPoint, CoordinateClueInfo>()
		// Medium
		.put(new WorldPoint(2479, 3158, 0), new CoordinateClueInfo("South of fruit tree patch, west of Tree Gnome Village."))
		.put(new WorldPoint(2887, 3154, 0), new CoordinateClueInfo("West of Banana plantation on Karamja."))
		.put(new WorldPoint(2743, 3151, 0), new CoordinateClueInfo("Entrance of Brimhaven dungeon."))
		.put(new WorldPoint(3184, 3150, 0), new CoordinateClueInfo("South of Lumbridge Swamp."))
		.put(new WorldPoint(3217, 3177, 0), new CoordinateClueInfo("East of Lumbridge Swamp."))
		.put(new WorldPoint(3007, 3144, 0), new CoordinateClueInfo("Near the entrance to the Asgarnian Ice Dungeon, south of Port Sarim (AIQ)."))
		.put(new WorldPoint(2896, 3119, 0), new CoordinateClueInfo("Near Karambwan fishing spot (DKP)."))
		.put(new WorldPoint(2697, 3207, 0), new CoordinateClueInfo("Centre of Moss Giant Island, west of Brimhaven."))
		.put(new WorldPoint(2679, 3110, 0), new CoordinateClueInfo("North of Hazelmere's house (CLS)."))
		.put(new WorldPoint(3510, 3074, 0), new CoordinateClueInfo("East of Uzer (DLQ)."))
		.put(new WorldPoint(3160, 3251, 0), new CoordinateClueInfo("West of trapdoor leading to H.A.M Hideout."))
		.put(new WorldPoint(2643, 3252, 0), new CoordinateClueInfo("South of Ardougne Zoo, North of Tower of Life (DJP)."))
		.put(new WorldPoint(2322, 3061, 0), new CoordinateClueInfo("South-west of Castle wars (BKP)."))
		.put(new WorldPoint(2875, 3046, 0), new CoordinateClueInfo("North of nature altar, north of Shilo Village (CKR)."))
		.put(new WorldPoint(2849, 3033, 0), new CoordinateClueInfo("West of nature altar, north of Shilo Village (CKR)."))
		.put(new WorldPoint(2848, 3296, 0), new CoordinateClueInfo("North of Crandor island."))
		.put(new WorldPoint(2583, 2990, 0), new CoordinateClueInfo("Feldip Hills, south-east of Gu'Thanoth (AKS)."))
		.put(new WorldPoint(3179, 3344, 0), new CoordinateClueInfo("In the cow pen north of the Lumbridge windmill."))
		.put(new WorldPoint(2383, 3370, 0), new CoordinateClueInfo("West of the outpost"))
		.put(new WorldPoint(3312, 3375, 0), new CoordinateClueInfo("North-west of Exam Centre, on the hill."))
		.put(new WorldPoint(3121, 3384, 0), new CoordinateClueInfo("North-east of Draynor Manor, near River Lum."))
		.put(new WorldPoint(3430, 3388, 0), new CoordinateClueInfo("West of Mort Myre Swamp."))
		.put(new WorldPoint(2920, 3403, 0), new CoordinateClueInfo("South-east of Taverley, near Lady of the Lake."))
		.put(new WorldPoint(2594, 2899, 0), new CoordinateClueInfo("South-east of Feldip Hills, by the crimson swifts (AKS)."))
		.put(new WorldPoint(2387, 3435, 0), new CoordinateClueInfo("West of Tree Gnome Stronghold, near the pen containing terrorbirds."))
		.put(new WorldPoint(2512, 3467, 0), new CoordinateClueInfo("Baxtorian Falls (Bring rope)."))
		.put(new WorldPoint(2381, 3468, 0), new CoordinateClueInfo("West of Tree Gnome Stronghold, north of the pen with terrorbirds."))
		.put(new WorldPoint(3005, 3475, 0), new CoordinateClueInfo("Ice Mountain, west of Edgeville."))
		.put(new WorldPoint(2585, 3505, 0), new CoordinateClueInfo("By the shore line north of the Coal Trucks."))
		.put(new WorldPoint(3443, 3515, 0), new CoordinateClueInfo("South of Slayer Tower."))
		.put(new WorldPoint(2416, 3516, 0), new CoordinateClueInfo("Tree Gnome Stronghold, west of Grand Tree, near swamp."))
		.put(new WorldPoint(3429, 3523, 0), new CoordinateClueInfo("South of Slayer Tower."))
		.put(new WorldPoint(2363, 3531, 0), new CoordinateClueInfo("North-east of Eagles' Peak."))
		.put(new WorldPoint(2919, 3535, 0), new CoordinateClueInfo("East of Burthorpe pub."))
		.put(new WorldPoint(3548, 3560, 0), new CoordinateClueInfo("Inside Fenkenstrain's Castle."))
		.put(new WorldPoint(1456, 3620, 0), new CoordinateClueInfo("Graveyard west of Shayzien (DJR)."))
		.put(new WorldPoint(2735, 3638, 0), new CoordinateClueInfo("East of Rellekka, north-west of Golden Apple Tree (AJR)."))
		.put(new WorldPoint(2681, 3653, 0), new CoordinateClueInfo("Rellekka, in the garden of the south-east house."))
		.put(new WorldPoint(2537, 3881, 0), new CoordinateClueInfo("Miscellania."))
		.put(new WorldPoint(2828, 3234, 0), new CoordinateClueInfo("Southern coast of Crandor."))
		.put(new WorldPoint(1247, 3726, 0), new CoordinateClueInfo("Just inside the Farming Guild"))
		.put(new WorldPoint(3770, 3898, 0), new CoordinateClueInfo("On the small island north-east of Fossil Island's mushroom forest."))
		// Hard
		.put(new WorldPoint(2209, 3161, 0), new CoordinateClueInfo("North-east of Tyras Camp."))
		.put(new WorldPoint(2181, 3206, 0), new CoordinateClueInfo("South of Elf Camp."))
		.put(new WorldPoint(3081, 3209, 0), new CoordinateClueInfo("Small Island (CLP)."))
		.put(new WorldPoint(3374, 3250, 0), new CoordinateClueInfo("Duel Arena combat area."))
		.put(new WorldPoint(2699, 3251, 0), new CoordinateClueInfo("Little island (AIR)."))
		.put(new WorldPoint(3546, 3251, 0), new CoordinateClueInfo("North-east of Burgh de Rott."))
		.put(new WorldPoint(3544, 3256, 0), new CoordinateClueInfo("North-east of Burgh de Rott."))
		.put(new WorldPoint(2841, 3267, 0), new CoordinateClueInfo("Crandor island."))
		.put(new WorldPoint(3168, 3041, 0), new CoordinateClueInfo("Bedabin Camp."))
		.put(new WorldPoint(2542, 3031, 0), new CoordinateClueInfo("Gu'Tanoth, may require 20gp."))
		.put(new WorldPoint(2581, 3030, 0), new CoordinateClueInfo("Gu'Tanoth island, enter cave north-west of Feldip Hills (AKS)."))
		.put(new WorldPoint(2961, 3024, 0), new CoordinateClueInfo("Ship yard (DKP)."))
		.put(new WorldPoint(2339, 3311, 0), new CoordinateClueInfo("East of Prifddinas on Arandar mountain pass."))
		.put(new WorldPoint(3440, 3341, 0), new CoordinateClueInfo("Nature Spirit's grotto."))
		.put(new WorldPoint(2763, 2974, 0), new CoordinateClueInfo("Cairn Isle, west of Shilo Village."))
		.put(new WorldPoint(3138, 2969, 0), new CoordinateClueInfo("West of Bandit Camp in Kharidian Desert."))
		.put(new WorldPoint(2924, 2963, 0), new CoordinateClueInfo("On the southern part of eastern Karamja."))
		.put(new WorldPoint(2838, 2914, 0), new CoordinateClueInfo("Kharazi Jungle, near water pool."))
		.put(new WorldPoint(3441, 3419, 0), new CoordinateClueInfo("Mort Myre Swamp."))
		.put(new WorldPoint(2950, 2902, 0), new CoordinateClueInfo("South-east of Kharazi Jungle."))
		.put(new WorldPoint(2775, 2891, 0), new CoordinateClueInfo("South-west of Kharazi Jungle."))
		.put(new WorldPoint(3113, 3602, 0), new CoordinateClueInfo("Wilderness. North of Edgeville (level 11)."))
		.put(new WorldPoint(2892, 3675, 0), new CoordinateClueInfo("On the summit of Trollheim."))
		.put(new WorldPoint(3168, 3677, 0), new CoordinateClueInfo("Wilderness. Graveyard of Shadows."))
		.put(new WorldPoint(2853, 3690, 0), new CoordinateClueInfo("Entrance to the troll Stronghold."))
		.put(new WorldPoint(3305, 3692, 0), new CoordinateClueInfo("Wilderness. West of eastern green dragon."))
		.put(new WorldPoint(3055, 3696, 0), new CoordinateClueInfo("Wilderness. Bandit Camp."))
		.put(new WorldPoint(3302, 3696, 0), new CoordinateClueInfo("Wilderness. West of eastern green dragon."))
		.put(new WorldPoint(1479, 3696, 0), new CoordinateClueInfo("Lizardman Canyon."))
		.put(new WorldPoint(2712, 3732, 0), new CoordinateClueInfo("North-east of Rellekka."))
		.put(new WorldPoint(2970, 3749, 0), new CoordinateClueInfo("Wilderness. Forgotten Cemetery."))
		.put(new WorldPoint(3094, 3764, 0), new CoordinateClueInfo("Wilderness. Mining site north of Bandit Camp."))
		.put(new WorldPoint(3311, 3769, 0), new CoordinateClueInfo("Wilderness. North of Venenatis."))
		.put(new WorldPoint(1460, 3782, 0), new CoordinateClueInfo("Lovakengj, near burning man."))
		.put(new WorldPoint(3244, 3792, 0), new CoordinateClueInfo("Wilderness. South-east of Lava Dragon Isle by some Chaos Dwarves."))
		.put(new WorldPoint(3140, 3804, 0), new CoordinateClueInfo("Wilderness. North of Ruins."))
		.put(new WorldPoint(2946, 3819, 0), new CoordinateClueInfo("Wilderness. Chaos Temple (level 38)."))
		.put(new WorldPoint(3771, 3825, 0), new CoordinateClueInfo("Fossil Island. East of Museum Camp."))
		.put(new WorldPoint(3013, 3846, 0), new CoordinateClueInfo("Wilderness. West of Lava Maze, before KBD's lair."))
		.put(new WorldPoint(3058, 3884, 0), new CoordinateClueInfo("Wilderness. Near runite ore north of Lava Maze."))
		.put(new WorldPoint(3290, 3889, 0), new CoordinateClueInfo("Wilderness. Demonic Ruins."))
		.put(new WorldPoint(3770, 3897, 0), new CoordinateClueInfo("Small Island north of Fossil Island."))
		.put(new WorldPoint(2505, 3899, 0), new CoordinateClueInfo("Small Island north-east of Miscellania (AJS)."))
		.put(new WorldPoint(3285, 3942, 0), new CoordinateClueInfo("Wilderness. Rogues' Castle."))
		.put(new WorldPoint(3159, 3959, 0), new CoordinateClueInfo("Wilderness. North of Deserted Keep, west of Resource Area."))
		.put(new WorldPoint(3039, 3960, 0), new CoordinateClueInfo("Wilderness. Pirates' Hideout."))
		.put(new WorldPoint(2987, 3963, 0), new CoordinateClueInfo("Wilderness. West of Wilderness Agility Course."))
		.put(new WorldPoint(3189, 3963, 0), new CoordinateClueInfo("Wilderness. North of Resource Area, near magic axe hut."))
		.put(new WorldPoint(2341, 3697, 0), new CoordinateClueInfo("North-east of the Piscatoris Fishing Colony bank."))
		.put(new WorldPoint(3143, 3774, 0), new CoordinateClueInfo("In level 32 Wilderness, by the black chinchompa hunting area."))
		.put(new WorldPoint(2992, 3941, 0), new CoordinateClueInfo("Wilderness Agility Course, past the log balance."))
		// Elite
		.put(new WorldPoint(2357, 3151, 0), new CoordinateClueInfo("Lletya."))
		.put(new WorldPoint(3587, 3180, 0), new CoordinateClueInfo("Meiyerditch."))
		.put(new WorldPoint(2820, 3078, 0), new CoordinateClueInfo("Tai Bwo Wannai. Hardwood Grove."))
		.put(new WorldPoint(3811, 3060, 0), new CoordinateClueInfo("Small island north-east of Mos Le'Harmless.", true, Varbits.BRAZIER_MOSLE_HARMLESS))
		.put(new WorldPoint(2180, 3282, 0), new CoordinateClueInfo("North of Elf Camp."))
		.put(new WorldPoint(2870, 2997, 0), new CoordinateClueInfo("North-east of Shilo Village."))
		.put(new WorldPoint(3302, 2988, 0), new CoordinateClueInfo("On top of a cliff to the west of Pollnivneach."))
		.put(new WorldPoint(2511, 2980, 0), new CoordinateClueInfo("Just south of Gu'Tanoth, west of gnome glider."))
		.put(new WorldPoint(2732, 3372, 0), new CoordinateClueInfo("Legends' Guild."))
		.put(new WorldPoint(3573, 3425, 0), new CoordinateClueInfo("North of Dessous's tomb from Desert Treasure."))
		.put(new WorldPoint(3828, 2848, 0), new CoordinateClueInfo("East of Harmony Island."))
		.put(new WorldPoint(3225, 2838, 0), new CoordinateClueInfo("South of Desert Treasure pyramid."))
		.put(new WorldPoint(1773, 3510, 0), new CoordinateClueInfo("Ruins north of the Hosidius mine."))
		.put(new WorldPoint(3822, 3562, 0), new CoordinateClueInfo("North-east of Dragontooth Island."))
		.put(new WorldPoint(3603, 3564, 0), new CoordinateClueInfo("North of the wrecked ship, outside of Port Phasmatys."))
		.put(new WorldPoint(2936, 2721, 0), new CoordinateClueInfo("Eastern shore of Crash Island."))
		.put(new WorldPoint(2697, 2705, 0), new CoordinateClueInfo("South-west of Ape Atoll."))
		.put(new WorldPoint(2778, 3678, 0), new CoordinateClueInfo("Mountain Camp."))
		.put(new WorldPoint(2827, 3740, 0), new CoordinateClueInfo("West of the entrance to the Ice Path, where the Troll child resides."))
		.put(new WorldPoint(2359, 3799, 0), new CoordinateClueInfo("Neitiznot."))
		.put(new WorldPoint(2194, 3807, 0), new CoordinateClueInfo("Pirates' Cove."))
		.put(new WorldPoint(2700, 3808, 0), new CoordinateClueInfo("Northwestern part of the Trollweiss and Rellekka Hunter area (DKS)."))
		.put(new WorldPoint(3215, 3835, 0), new CoordinateClueInfo("Wilderness. Lava Dragon Isle."))
		.put(new WorldPoint(3369, 3894, 0), new CoordinateClueInfo("Wilderness. Fountain of Rune."))
		.put(new WorldPoint(2065, 3923, 0), new CoordinateClueInfo("Outside the western wall on Lunar Isle."))
		.put(new WorldPoint(3188, 3933, 0), new CoordinateClueInfo("Wilderness. Resource Area."))
		.put(new WorldPoint(2997, 3953, 0), new CoordinateClueInfo("Wilderness. Inside Agility Training Area."))
		.put(new WorldPoint(3380, 3963, 0), new CoordinateClueInfo("Wilderness. North of Volcano."))
		.put(new WorldPoint(3051, 3736, 0), new CoordinateClueInfo("East of the Wilderness Obelisk in 28 Wilderness."))
		.put(new WorldPoint(2316, 3814, 0), new CoordinateClueInfo("West of Neitiznot, near the bridge."))
		.put(new WorldPoint(2872, 3937, 0), new CoordinateClueInfo("Weiss."))
		.put(new WorldPoint(2835, 2998, 0), new CoordinateClueInfo("Northeast corner of the Island of Stone."))
		// Master
		.put(new WorldPoint(2178, 3209, 0), new CoordinateClueInfo("South of Elf Camp."))
		.put(new WorldPoint(2155, 3100, 0), new CoordinateClueInfo("South of Port Tyras (BJS)."))
		.put(new WorldPoint(2217, 3092, 0), new CoordinateClueInfo("Poison Waste island (DLR)."))
		.put(new WorldPoint(3830, 3060, 0), new CoordinateClueInfo("Small island located north-east of Mos Le'Harmless.", true, Varbits.BRAZIER_MOSLE_HARMLESS))
		.put(new WorldPoint(2834, 3271, 0), new CoordinateClueInfo("Crandor island."))
		.put(new WorldPoint(2732, 3284, 0), new CoordinateClueInfo("Witchaven."))
		.put(new WorldPoint(3622, 3320, 0), new CoordinateClueInfo("Meiyerditch. Outside mine."))
		.put(new WorldPoint(2303, 3328, 0), new CoordinateClueInfo("East of Prifddinas."))
		.put(new WorldPoint(3570, 3405, 0), new CoordinateClueInfo("North of Dessous's tomb from Desert Treasure."))
		.put(new WorldPoint(2840, 3423, 0), new CoordinateClueInfo("Water Obelisk Island."))
		.put(new WorldPoint(3604, 3564, 0), new CoordinateClueInfo("North of the wrecked ship, outside of Port Phasmatys (ALQ)."))
		.put(new WorldPoint(3085, 3569, 0), new CoordinateClueInfo("Wilderness. Obelisk of Air."))
		.put(new WorldPoint(2934, 2727, 0), new CoordinateClueInfo("Eastern shore of Crash Island."))
		.put(new WorldPoint(1451, 3695, 0), new CoordinateClueInfo("West side of Lizardman Canyon with Lizardman shaman."))
		.put(new WorldPoint(2538, 3739, 0), new CoordinateClueInfo("Waterbirth Island. Bring a pet rock and rune thrownaxe."))
		.put(new WorldPoint(1698, 3792, 0), new CoordinateClueInfo("Arceuus church."))
		.put(new WorldPoint(2951, 3820, 0), new CoordinateClueInfo("Wilderness. Chaos Temple (level 38)."))
		.put(new WorldPoint(2202, 3825, 0), new CoordinateClueInfo("Pirates' Cove, between Lunar Isle and Rellekka."))
		.put(new WorldPoint(1761, 3853, 0), new CoordinateClueInfo("Arceuus essence mine."))
		.put(new WorldPoint(2090, 3863, 0), new CoordinateClueInfo("South of Lunar Isle, west of Astral altar."))
		.put(new WorldPoint(1442, 3878, 0), new CoordinateClueInfo("Sulphur Mine."))
		.put(new WorldPoint(3380, 3929, 0), new CoordinateClueInfo("Wilderness. Near Volcano."))
		.put(new WorldPoint(3188, 3939, 0), new CoordinateClueInfo("Wilderness. Resource Area."))
		.put(new WorldPoint(3304, 3941, 0), new CoordinateClueInfo("Wilderness. East of Rogues' Castle."))
		.put(new WorldPoint(2994, 3961, 0), new CoordinateClueInfo("Wilderness. Inside Agility Training Area."))
		.put(new WorldPoint(1248, 3751, 0), new CoordinateClueInfo("In the north wing of the Farming Guild."))
		.build();

	private final String text;
	private final WorldPoint location;
	/**
	 * For regions which are mirrored, the location of the the clue in the mirrored region.
	 **/
	@Nullable
	private final WorldPoint mirrorLocation;
	private final Varbits hasFirePit;

	public CoordinateClue(String text, WorldPoint location, WorldPoint mirrorLocation)
	{
		this.text = text;
		this.location = location;
		this.mirrorLocation = mirrorLocation;
		this.hasFirePit = (CLUES.get(location) != null ? CLUES.get(location).lightSource : null);
		if (this.hasFirePit != null)
		{
			setRequiresLight(true);
			setHasFirePit(this.hasFirePit);
		}
		setRequiresSpade(true);
	}
	@Override
	public WorldPoint[] getLocations()
	{
		if (mirrorLocation != null)
		{
			return new WorldPoint[]{location, mirrorLocation};
		}
		else
		{
			return new WorldPoint[]{location};
		}
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Coordinate Clue").build());

		String solution = (CLUES.get(location) != null ? CLUES.get(location).directions : null);

		if (solution != null)
		{
			panelComponent.getChildren().add(LineComponent.builder()
					.left(solution)
					.build());
			panelComponent.getChildren().add(LineComponent.builder().build());
		}

		panelComponent.getChildren().add(LineComponent.builder()
				.left("Click the clue scroll on your world map to see dig location.")
				.build());
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		for (WorldPoint worldPoint : getLocations())
		{
			LocalPoint localLocation = LocalPoint.fromWorld(plugin.getClient(), worldPoint);

			if (localLocation != null)
			{
				OverlayUtil.renderTileOverlay(plugin.getClient(), graphics, localLocation, plugin.getSpadeImage(), Color.ORANGE);
			}
		}
	}
}
