package hyf.conversion.config;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * @author yafei.hou
 * Created by yafei.hou on 2017/11/27.
 */
public class MyFormatterRegistrar implements FormatterRegistrar {


    private DateFormatter dateFormatter;

    public MyFormatterRegistrar(DateFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addFormatter(dateFormatter);
    }

    public void setDateFormatter(DateFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    public DateFormatter getDateFormatter() {
        return dateFormatter;
    }
}
