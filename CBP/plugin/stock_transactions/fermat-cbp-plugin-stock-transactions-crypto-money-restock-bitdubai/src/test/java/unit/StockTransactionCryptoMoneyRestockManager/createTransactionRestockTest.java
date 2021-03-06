package unit.StockTransactionCryptoMoneyRestockManager;

import com.bitdubai.fermat_api.layer.all_definition.enums.BlockchainNetworkType;
import com.bitdubai.fermat_api.layer.all_definition.enums.CryptoCurrency;
import com.bitdubai.fermat_cbp_api.all_definition.enums.OriginTransaction;
import com.bitdubai.fermat_cbp_api.layer.stock_transactions.crypto_money_destock.exceptions.CantCreateCryptoMoneyDestockException;
import com.bitdubai.fermat_cbp_api.layer.stock_transactions.crypto_money_restock.exceptions.CantCreateCryptoMoneyRestockException;
import com.bitdubai.fermat_cbp_plugin.layer.stock_transactions.crypto_money_restock.developer.bitdubai.version_1.structure.StockTransactionCryptoMoneyRestockManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;

/**
 * Created by Jose Vilchez on 18/01/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class createTransactionRestockTest {

    @Test
    public void createTransactionRestock() throws CantCreateCryptoMoneyDestockException, CantCreateCryptoMoneyRestockException {
        StockTransactionCryptoMoneyRestockManager stockTransactionCryptoMoneyRestockManager = mock(StockTransactionCryptoMoneyRestockManager.class, Mockito.RETURNS_DEEP_STUBS);
        doCallRealMethod().when(stockTransactionCryptoMoneyRestockManager).createTransactionRestock(Mockito.any(String.class), Mockito.any(CryptoCurrency.class), Mockito.any(String.class)
                , Mockito.any(String.class), Mockito.any(BigDecimal.class), Mockito.any(String.class), Mockito.any(BigDecimal.class), Mockito.any(OriginTransaction.class),Mockito.anyString(),Mockito.any(BlockchainNetworkType.class));
    }

}
