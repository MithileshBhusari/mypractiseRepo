package tutorial1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerWithKey{
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            final Logger logger = LoggerFactory.getLogger(ProducerDemoWithCallback.class);


            String bootstrapServers = "127.0.0.1:9092";


            //create Producer Properties
            Properties properties = new Properties();
            properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
            properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
            //Create Producer
            KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

            for(int i=0;i<10;i++) {
                //create a producer
                String topic="fifth_topic";
                String value="hello world"+Integer.toString(i);
                String key="id_"+Integer.toString(i);
                ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic,key, value);
                //send Data --asynchronous
                logger.info("key: "+key); //log the key
                //id_0 going to partition 1
                //id_1 going to partition 0
                //id_2 partition 2
                //id_3
                producer.send(producerRecord, new Callback() {
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        //executes every time a record is successfully sent or an exception is thrown
                        if (e == null) {
                            //Record was successfully sent
                            logger.info("Received new metadata. \n" +
                                    "Topic:" + recordMetadata.topic() + "\n" +
                                    "Partition:" + recordMetadata.partition() + "\n" +
                                    "Offset:" + recordMetadata.offset() + "\n" +
                                    "Timestamp: " + recordMetadata.timestamp());
                        } else {
                            logger.error("Error while processing : ", e);
                        }
                    }
                }).get();  //block the .send() to make it synchronous  - don't do this in production!
            }
            //flush data
            producer.flush();

            //flush and close producer
            producer.close();
        }
}
