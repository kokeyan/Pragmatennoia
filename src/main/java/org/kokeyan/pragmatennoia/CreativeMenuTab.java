package org.kokeyan.pragmatennoia;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.kokeyan.pragmatennoia.item.ModItems;

public class CreativeMenuTab {

    //クリエタブ登録用の窓口設置
    //また、専用メソッドがないので汎用メソッドの"create"を使う。
    //また、今回はItemでもBlockでもないので"CreativeModeTab型"に限定。
    //また、CREATIVE_MODE_TABだと下の種類指定の変数と名前が被って見にくいのでTAB"S"にしておく。
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            // CREATIVE_MODE_TABという種類の登録を実行。あとMOD_IDも一緒に指定する。
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Main.MOD_ID);

    //クリエタブNo.1登録
    //ちなみにDeferredHolderはDeferredItemのより汎用的、派生元のような存在
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PRAGMATENNOIA_TAB_1 =
            CREATIVE_MODE_TABS.register(
                    // ID指定
                    "pragmatennoia_tab_1",
                    // ラムダ式で、後で必要になったときにこのbuilderメソッドを実行するようにする。
                    // ←アイテム等が完全に登録が終わっていない状態でそのアイテム等をクリエタブに登録しようとするため、nullが帰ってきてクラッシュする可能性があるため。
                    // また、クリエタブは設定が多いので.builder()で空の設計図を作りそこから.引数で設定を追加していき、.build()で組み立てる。 <-なんかHTMLみたい
                    () -> CreativeModeTab
                            .builder()
                            .icon(() -> new ItemStack(ModItems.ITEMS.getEntries().iterator().next().get()))
                            .title(Component.translatable("creativetab.pragmatennoia.main"))
                            .displayItems((params, output) -> {
                                ModItems.ITEMS.getEntries().forEach(entry -> output.accept(entry.get()));
                            })
                            .build()
            );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
