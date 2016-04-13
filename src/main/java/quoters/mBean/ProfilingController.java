package quoters.mBean;

/**
 * Controller with field that could be changed in JVMConsole
 * in run time.
 *
 * Created by dkorolev on 4/13/2016.
 */
public class ProfilingController implements ProfilingControllerMBean {
    private boolean enabled;


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
