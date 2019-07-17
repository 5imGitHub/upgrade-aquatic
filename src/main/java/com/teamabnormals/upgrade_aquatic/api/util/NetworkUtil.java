package com.teamabnormals.upgrade_aquatic.api.util;

import com.teamabnormals.upgrade_aquatic.common.network.MessageCSetRestTime;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.PacketDistributor;

public class NetworkUtil {
	
	@OnlyIn(Dist.DEDICATED_SERVER)
	public static void updateCPlayerRestTime(int entityId, int sleepTime) {
		UpgradeAquatic.CHANNEL.send(PacketDistributor.ALL.noArg(), new MessageCSetRestTime(entityId, sleepTime));
	}
	
}
