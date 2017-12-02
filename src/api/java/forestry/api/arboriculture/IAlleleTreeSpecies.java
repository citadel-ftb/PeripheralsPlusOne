/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.arboriculture;

import java.util.Collection;

import forestry.api.core.IModelManager;
import forestry.api.genetics.IAlleleProperty;
import forestry.api.genetics.IAlleleSpecies;
import forestry.api.genetics.IFruitFamily;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IAlleleTreeSpecies extends IAlleleSpecies, IAlleleProperty<IAlleleTreeSpecies> {

	@Override
	ITreeRoot getRoot();

	/**
	 * @return Native plant type of this species.
	 */
	EnumPlantType getPlantType();

	/**
	 * @return List of all {@link IFruitFamily}s which can grow on leaves generated by this species.
	 */
	Collection<IFruitFamily> getSuitableFruit();

	/**
	 * @return Tree generator for this species.
	 */
	ITreeGenerator getGenerator();

	/**
	 * @return The modid from the mod of the species.
	 */
	String getModID();
	
	/**
	 * @return Float between 0 and 1 representing the rarity of the species, will affect spawn rate. If it's 0, it will not spawn.
	 */
	float getRarity();

	IWoodProvider getWoodProvider();
	
	ILeafProvider getLeafProvider();
	
	IGrowthProvider getGrowthProvider();

	/* MODELS AND OVERRIDES */
	@SideOnly(Side.CLIENT)
	ILeafSpriteProvider getLeafSpriteProvider();

	@SideOnly(Side.CLIENT)
	int getGermlingColour(EnumGermlingType type, int renderPass);

	@SideOnly(Side.CLIENT)
	ModelResourceLocation getGermlingModel(EnumGermlingType type);

	@SideOnly(Side.CLIENT)
	void registerModels(Item item, IModelManager manager, EnumGermlingType type);

}