package git.lunf.helper;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import git.lunf.model.PartCncRun;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvReader {

    ClassLoader classLoader = getClass().getClassLoader();

    public List<PartCncRun> readPartCncCsvFile(String fileCvsName) {

        List<PartCncRun> partList = new ArrayList<>();

        try {

            InputStream inputStream = classLoader.getResourceAsStream(fileCvsName);


            Reader reader = new InputStreamReader(inputStream);

            CsvToBean<PartCncRun> csvToBean = new CsvToBeanBuilder<PartCncRun>(reader)
                    .withType(PartCncRun.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<PartCncRun> cncRunIterator = csvToBean.iterator();


            while (cncRunIterator.hasNext()) {
                partList.add(cncRunIterator.next());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Fail to read parts csv " + ex.getMessage());
        }

        return partList;
    }
}
