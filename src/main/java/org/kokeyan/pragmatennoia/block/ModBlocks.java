package org.kokeyan.pragmatennoia.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.kokeyan.pragmatennoia.Main;
import org.kokeyan.pragmatennoia.item.ModItems;

import javax.swing.*;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Main.MOD_ID);

    // record...複数の値を持てる変数(定数)(クラス)を作る。
    // for文などでものによって引数を変更したい時に使う。
    // ここではブロック登録用の「名前」「硬さ」「爆発耐性」「必要ツール」
    public record BlockData(String name, float strength, float explosionStrength) {};

    //recordで作ったBlockDataクラスを使ってリストで登録
    private static final BlockData[] SIMPLE_STONE_BLOCK = {
            new BlockData("logium_block", 2.0f , 2.5f),
            new BlockData("logium_ore", 2.0f, 2.0f),
            new BlockData("deepslate_logium_ore", 2.5f, 2.0f),
            new BlockData("raw_logium_block", 2.0f, 2.0f),
            new BlockData("steel_block", 2.5f, 3.0f),
            new BlockData("limestone", 1.5f, 0.5f),
    };
    // アイテム追加の場合、DeferredBlock<Block>型に変換しないといけないのでこの処理を入れている。
    // ちなみに[]をつけておくことでリスト形式にしている。
    private static final DeferredBlock<Block>[] BLOCK_ITEMS =
            //DeferredBlock用の登録枠をSIMPLE_STONE_BLOCKの要素数(length)分用意する。
            new DeferredBlock[SIMPLE_STONE_BLOCK.length];


    //拡張for構文から戻したのは、SIMPLE_STONE_BLOCKとSとBLOCK_ITEMSを同期させるため。
    static {
        for (int i = 0; i < SIMPLE_STONE_BLOCK.length; i++) {
            //変数[i]はこの変数リストのi番目を取り出すという意味。
            BlockData data = SIMPLE_STONE_BLOCK[i];
            BLOCK_ITEMS[i] =
                    BLOCKS.registerSimpleBlock(
                            data.name, BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.STONE)
                                    .strength(data.strength, data.explosionStrength)
            );
        }

        for (DeferredBlock<Block> block : BLOCK_ITEMS) {
            ModItems.ITEMS.registerSimpleBlockItem(block);
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
