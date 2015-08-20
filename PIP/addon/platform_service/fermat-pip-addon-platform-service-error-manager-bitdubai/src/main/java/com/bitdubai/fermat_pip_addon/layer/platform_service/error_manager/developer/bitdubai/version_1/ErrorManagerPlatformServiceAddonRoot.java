package com.bitdubai.fermat_pip_addon.layer.platform_service.error_manager.developer.bitdubai.version_1;

import com.bitdubai.fermat_api.Addon;
import com.bitdubai.fermat_api.FermatException;
import com.bitdubai.fermat_api.Service;
import com.bitdubai.fermat_api.layer.all_definition.enums.UISource;
import com.bitdubai.fermat_api.layer.all_definition.event.PlatformEvent;
import com.bitdubai.fermat_api.layer.all_definition.navigation_structure.enums.Wallets;
import com.bitdubai.fermat_api.layer.dmp_engine.sub_app_runtime.enums.SubApps;
import com.bitdubai.fermat_api.layer.all_definition.enums.Addons;
import com.bitdubai.fermat_api.layer.all_definition.enums.PlatformComponents;
import com.bitdubai.fermat_api.layer.all_definition.enums.Plugins;
import com.bitdubai.fermat_api.layer.all_definition.enums.ServiceStatus;
import com.bitdubai.fermat_api.layer.osa_android.database_system.DealsWithPlatformDatabaseSystem;
import com.bitdubai.fermat_api.layer.osa_android.database_system.PlatformDatabaseSystem;

//import com.bitdubai.fermat_pip_addon.layer.platform_service.error_manager.developer.bitdubai.version_1.functional.ErrorReport;
import com.bitdubai.fermat_pip_addon.layer.platform_service.error_manager.developer.bitdubai.version_1.functional.ErrorReport;
import com.bitdubai.fermat_pip_api.layer.pip_platform_service.error_manager.*;
import com.bitdubai.fermat_pip_addon.layer.platform_service.error_manager.developer.bitdubai.version_1.structure.ErrorManagerRegistry;
import com.bitdubai.fermat_pip_addon.layer.platform_service.error_manager.developer.bitdubai.version_1.structure.ErrorManagerReportAgent;

import java.io.Serializable;

/**
 * Created by ciencias on 05.02.15
 * Modified by Federico Rodriguez on 01.05.15
 */
public class ErrorManagerPlatformServiceAddonRoot implements Addon,DealsWithPlatformDatabaseSystem, ErrorManager, Service,Serializable {

    /**
     * ErrorManagerRegistry variable
     */
    private ErrorManagerRegistry errorManagerRegistry;

    /**
     * ErrorManagerReportAgent variable
     */
    private ErrorManagerReportAgent errorManagerReportAgent;

    /**
     * DealsWithPlatformDatabaseSystem Interface member variables.
     */
    private PlatformDatabaseSystem platformDatabaseSystem;

    /**
     * Service Interface member variables.
     */
    private ServiceStatus serviceStatus = ServiceStatus.CREATED;

    //private ErrorManagerDatabaseFactory errorManagerDatabaseFactory;

    @Override
    public void setPlatformDatabaseSystem(PlatformDatabaseSystem platformDatabaseSystem) {
        this.platformDatabaseSystem = platformDatabaseSystem;
    }

    public PlatformDatabaseSystem getPlatformDatabaseSystem(){
        return this.platformDatabaseSystem;
    }

    /**
     * DealsWithPluginDatabaseSystem Interface implementation.
     */

    /**
     * ErrorManager Interface implementation.
     */
    @Override
    public void reportUnexpectedPlatformException(PlatformComponents exceptionSource, UnexpectedPlatformExceptionSeverity unexpectedPlatformExceptionSeverity, Exception exception) {
        processException(exceptionSource.name(), unexpectedPlatformExceptionSeverity.name(), exception);
    }

    @Override
    public void reportUnexpectedPluginException(Plugins exceptionSource, UnexpectedPluginExceptionSeverity unexpectedPluginExceptionSeverity, Exception exception) {
        processException(exceptionSource.toString(), unexpectedPluginExceptionSeverity.toString(), exception);
    }

    @Override
    public void reportUnexpectedWalletException(Wallets exceptionSource, UnexpectedWalletExceptionSeverity unexpectedWalletExceptionSeverity, Exception exception) {
        processException(exceptionSource.toString(), unexpectedWalletExceptionSeverity.toString(),exception);
    }

    @Override
    public void reportUnexpectedAddonsException(Addons exceptionSource, UnexpectedAddonsExceptionSeverity unexpectedAddonsExceptionSeverity, Exception exception) {
        processException(exceptionSource.toString(), unexpectedAddonsExceptionSeverity.toString(), exception);
    }

    @Override
    public void reportUnexpectedSubAppException(SubApps exceptionSource, UnexpectedSubAppExceptionSeverity unexpectedSubAppExceptionSeverity, Exception exception) {
        processException(exceptionSource.toString(), unexpectedSubAppExceptionSeverity.toString(), exception);
    }

    @Override
    public void reportUnexpectedUIException(UISource exceptionSource, UnexpectedUIExceptionSeverity unexpectedAddonsExceptionSeverity, Exception exception) {
        processException(exceptionSource.toString(), unexpectedAddonsExceptionSeverity.toString(), exception);
    }

    @Override
    public void reportUnexpectedEventException(PlatformEvent exceptionSource, Exception exception) {
        processException(exceptionSource.toString(), "Unknow", exception);
    }

    /**
     * Service Interface implementation.
     */

    @Override
    public void start() {
        this.serviceStatus = ServiceStatus.STARTED;
    }

    @Override
    public void pause() {
        this.serviceStatus = ServiceStatus.PAUSED;

    }

    @Override
    public void resume() {

        this.serviceStatus = ServiceStatus.STARTED;

    }

    @Override
    public void stop() {

        this.serviceStatus = ServiceStatus.STOPPED;
    }

    @Override
    public ServiceStatus getStatus() {
        return serviceStatus;
    }

    private void processException(final String source, final String severity, final Exception exception){
        printErrorReport(source, severity, FermatException.wrapException(exception));
    }

    private void printErrorReport(final String source, final String severity, final FermatException exception){
        System.err.println(new ErrorReport(source, severity, exception).generateReport());
    }

}
