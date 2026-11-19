// メインクラス
// パスの設定
package org.kokeyan.pragmatennoia;

// インポートたち
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.kokeyan.pragmatennoia.block.ModBlocks;
import org.kokeyan.pragmatennoia.item.ModItems;
import org.slf4j.Logger;

// Modの環境IDを登録&初期化処理
@Mod(Main.MOD_ID)
// メインクラスの登録
public class Main {
    private static final Logger LOGGER = LogUtils.getLogger();

    //Welcomeメッセージ用メソッドloggerの定義
    public void logger() {
        LOGGER.info("PPPPP   RRRRR    AAA    GGGG   M   M   AAA   TTTTT  EEEEE  N   N  N   N   OOO  IIIII  AAA");
        LOGGER.info("P   P   R   R   A   A  G       MM MM  A   A    T    E      NN  N  NN  N  O   O   I   A   A");
        LOGGER.info("PPPPP   RRRRR   AAAAA  G  GG   M M M  AAAAA    T    EEE    N N N  N N N  O   O   I   AAAAA");
        LOGGER.info("P       R  R    A   A  G   G   M   M  A   A    T    E      N  NN  N  NN  O   O   I   A   A");
        LOGGER.info("P       R   R   A   A   GGGG   M   M  A   A    T    EEEEE  N   N  N   N   OOO  IIIII A   A");
        LOGGER.info("");
        LOGGER.info("                           ...Welcome to the PRAGMATENNOIA WORLD...");
        LOGGER.info("");
        LOGGER.info("Start Loading...");
    }

    // MOD_ID変数を指定
    // 変数指定においてpublicは公開、staticは単数？、finalは再代入不可(定数)
    public static final String MOD_ID = "pragmatennoia";

    //メソッド実行場所
    public Main(IEventBus modEventBus) {
        logger();
        ModItems.register(modEventBus);
        CreativeMenuTab.register(modEventBus);
        ModBlocks.register(modEventBus);
    }
}
