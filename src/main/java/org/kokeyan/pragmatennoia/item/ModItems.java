// アイテム登録クラス

//　クラスディレクトリ宣言
// わかりやすくitemパッケージで分別してる
package org.kokeyan.pragmatennoia.item;

//インポート
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.kokeyan.pragmatennoia.Main;

// クラス名宣言
// ちなみにクラス名は指定はない
// アクセス修飾子「public」 : どこのクラスからでもこのクラスを引っ張ってこれる(importできる)。
public class ModItems {

    //"DeferredRegister"というクラスのアイテム登録用の型(Items)に同クラスで定義されている
    // createItemsというstaticメソッドの処理で帰ってきたものを登録する
    public static final DeferredRegister.Items ITEMS =

            //さっそくMOD_IDで定義したmod idを使う！
            DeferredRegister.createItems(Main.MOD_ID);

    // シンプルアイテム一覧登録
    private static final String[] SIMPLE_ITEM_NAMES = {
            "concept_base",
            "chroma_source",
            "mineral_source",
            // essence
            "chroma_essence",
            "earth_essence",
            "rigidity_essence",
            "nature_essence",
            "life_essence",
            // pragmatennoia
            "chroma_pragma",
            "earth_pragma",
            "rigidity_pragma",
            "nature_pragma",
            "life_pragma",
            // raw+ingot+nugget
            "raw_logium",
            "logium_ingot",
            "logium_nugget",
            // steel
            "steel_ingot",
            "steel_nugget",
            "limestone_dust",
            "coke",
            "pig_iron"


    };

    static {
        for (String name : SIMPLE_ITEM_NAMES) {
            ITEMS.registerSimpleItem(name, new Item.Properties());
        }
    }

    //"DeferredItem"だけでは通常アイテムなのかブロックアイテムなのかわからないので
    //Itemという型の制限をつけて判別させる
    //こうすることで後に参照するときにItem型として扱えるため楽。
    //CONCEPT_BASEという変数を作っておくことでクリエタブとかで参照するのに楽。
    // 上のfor文による登録がされてるので下のアイテム登録は無効化中。
    // public static final DeferredItem<Item> CONCEPT_BASE =

            //さっき作ったITEMSという変数(窓口)にSimpleItemをRegistryしてと言っている
    //         ITEMS.registerSimpleItem(

                    //アイテム情報の引数
                    //アイテムIDの設定
    //                 "concept_base",
                    //アイテムのスタック上限などの性質を設定できる
    //                 new Item.Properties(
                            //例 : .stacksTo(32)
    //                 )
    //                 );

    // 引数を変数として定義した後にそれを使って処理をする。(これをメソッドという)
    // 本来ならメソッドの処理結果が値として帰ってくるが、今回はなにも返り値がない
    // のでそういう時のvoid型を使う。
    // 一応return(何か);は処理を強制的に終わらせるときに使う。
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        //ここに隠れた"return;"がある。
    }
}
