package unit.com.bitdubai.desktop.sub_app_manager.fragmentFactory.SubAppManagerFragmentFactory;

import com.bitdubai.desktop.sub_app_manager.BuildConfig;
import com.bitdubai.desktop.sub_app_manager.fragmentFactory.SubAppManagerFragmentFactory;
import com.bitdubai.desktop.sub_app_manager.fragmentFactory.SubAppManagerFragmentsEnumType;
import com.bitdubai.fermat_android_api.layer.definition.wallet.FermatFragment;
import com.bitdubai.fermat_android_api.layer.definition.wallet.enums.FermatFragmentsEnumType;
import com.bitdubai.fermat_android_api.layer.definition.wallet.exceptions.FragmentNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by nelson on 17/09/15.
 */
public class GetFermatFragmentEnumTypeTest {
    private SubAppManagerFragmentFactory fragmentFactory;
    private final String ENUM_TYPE_CODE = "MF";


    @Before
    public void setUp() throws Exception {
        fragmentFactory = new SubAppManagerFragmentFactory();
    }


    @Test
    public void enumTypeFound() throws Exception {
        FermatFragmentsEnumType expectedEnumType = SubAppManagerFragmentsEnumType.MAIN_FRAGMET;
        FermatFragmentsEnumType actualEnumType = fragmentFactory.getFermatFragmentEnumType(ENUM_TYPE_CODE);

        assertThat(actualEnumType).isEqualTo(expectedEnumType);
    }


    @Test
    public void enumTypeNotFound() throws Exception {
        FermatFragmentsEnumType actualEnumType = fragmentFactory.getFermatFragmentEnumType(null);

        assertThat(actualEnumType).isNull();
    }
}