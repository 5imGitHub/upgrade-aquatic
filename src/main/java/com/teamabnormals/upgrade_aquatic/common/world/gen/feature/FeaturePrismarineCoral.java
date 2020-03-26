package com.teamabnormals.upgrade_aquatic.common.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.teamabnormals.upgrade_aquatic.common.world.gen.UAFeatures;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.CaveEdgeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author - SmellyModder(Luke Tonon)
 */
public class FeaturePrismarineCoral extends Feature<NoFeatureConfig> {
	protected static final BlockState CORAL_BLOCK_BLOCK(boolean elder) {
		return !elder ? UABlocks.PRISMARINE_CORAL_BLOCK.get().getDefaultState() : UABlocks.ELDER_PRISMARINE_CORAL_BLOCK.get().getDefaultState();
	}
	protected static final BlockState CORAL_BLOCK(boolean elder) {
		return !elder ? UABlocks.PRISMARINE_CORAL.get().getDefaultState() : UABlocks.ELDER_PRISMARINE_CORAL.get().getDefaultState();
	}
	protected static final BlockState CORAL_FAN(boolean elder) {
		return !elder ? UABlocks.PRISMARINE_CORAL_FAN.get().getDefaultState() : UABlocks.ELDER_PRISMARINE_CORAL_FAN.get().getDefaultState();
	}
	protected static final BlockState CORAL_WALL_FAN(boolean elder) {
		return !elder ? UABlocks.PRISMARINE_CORAL_WALL_FAN.get().getDefaultState() : UABlocks.ELDER_PRISMARINE_CORAL_WALL_FAN.get().getDefaultState();
	}
	protected static final BlockState CORAL_SHOWER(boolean elder) {
		return !elder ? UABlocks.PRISMARINE_CORAL_SHOWER.get().getDefaultState() : UABlocks.ELDER_PRISMARINE_CORAL_SHOWER.get().getDefaultState();
	}

	public FeaturePrismarineCoral(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
//		if(rand.nextDouble() <= 1) {
			FeaturePrismarineCoralShelf.placeFeature(worldIn, generator, rand, pos, config);
//		} else {
//			FeaturePrismarineStalactite.placeFeature(worldIn, generator, rand, pos, config);
//		}
		return false;
	}
	
	public static void addFeature() {
		ForgeRegistries.BIOMES.getValues().stream().forEach(FeaturePrismarineCoral::process);
	}
	
	private static void process(Biome biome) {
		biome.addFeature(GenerationStage.Decoration.RAW_GENERATION, Biome.createDecoratedFeature(UAFeatures.PRISMARINE_CORAL.get(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.CARVING_MASK, new CaveEdgeConfig(GenerationStage.Carving.LIQUID, 0.0125F)));
	}
	
}
