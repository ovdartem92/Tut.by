package by.tut.ta.framework.appender;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.testng.Reporter;

public class TestNGReportAppender extends AppenderSkeleton {
    @Override
    protected void append(LoggingEvent loggingEvent) {
        Reporter.log(getLayout().format(loggingEvent));
    }

    @Override
    public void close() {
        //unused method
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }
}
