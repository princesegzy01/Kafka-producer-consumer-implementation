
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;


public class kafkaProducerApp {

    public static void main(String[] args){

        // create a properties dictionary
        Properties props = new Properties();

        props.put("bootstrap.servers","localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> myProducer = new KafkaProducer<String, String>(props);

        try {
            for (int i = 0; i <100; i++){
                myProducer.send(new ProducerRecord<String, String>("new_topic",  Integer.toString(i), "myMessage" + Integer.toString(i)));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myProducer.close();
        }

    }


}
