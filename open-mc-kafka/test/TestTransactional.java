import org.junit.Test;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author WhomHim
 * @description
 * @date Create in 2019/5/29 23:57
 */
public class TestTransactional {

    private final KafkaTemplate<String, String> template;

    public TestTransactional() {
        template = null;
    }

    @Test
    @Transactional
    public void testTransactionalAnnotation() {
        template.send("topic.quick.tran", "test transactional annotation");
        throw new RuntimeException("fail");
    }
}
