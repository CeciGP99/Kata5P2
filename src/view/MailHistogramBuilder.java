package view;

import java.util.List;
import model.Histogram;
import model.Mail;

public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<Mail> mails){
        Histogram<String> histogram = new Histogram<>();
        for (Mail mail : mails){
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }
}
