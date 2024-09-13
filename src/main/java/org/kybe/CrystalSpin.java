package org.kybe;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import org.rusherhack.client.api.events.client.EventUpdate;
import org.rusherhack.client.api.feature.module.ModuleCategory;
import org.rusherhack.client.api.feature.module.ToggleableModule;
import org.rusherhack.core.event.stage.Stage;
import org.rusherhack.core.event.subscribe.Subscribe;
import org.rusherhack.core.setting.NumberSetting;

public class CrystalSpin extends ToggleableModule {

	private final NumberSetting<Integer> speed = new NumberSetting<>("Speed", "Speed boost off crystals", 1, -10, 10)
			.incremental(1);

	public CrystalSpin() {
		super("Crystal Spin", "Crystal Spin", ModuleCategory.RENDER);
		this.registerSettings(
			speed
		);
	}

	@Subscribe(stage = Stage.POST)
	public void onUpdate(EventUpdate e) {
		if (mc.level == null) return;
		for (Entity entity : mc.level.entitiesForRendering()) {
			if (entity.getType() == EntityType.END_CRYSTAL)
				((EndCrystal)entity).time = ((EndCrystal)entity).time + speed.getValue();
		}
	}
}
