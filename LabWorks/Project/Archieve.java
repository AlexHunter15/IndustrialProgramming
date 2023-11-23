import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archieve {
    public static void createZipArchive(ArrayList<Fabric> fabrics, String zipFileName) {
        try {
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);

            for (int i = 0; i < fabrics.size(); i++) {
                Fabric fabric = fabrics.get(i);

                // Creating an entry for each Person in the zip file
                ZipEntry entry = new ZipEntry("house" + i + ".txt");
                zos.putNextEntry(entry);

                // Writing Person's data to the zip entry
                String personData = fabric.getType() + " " + fabric.getPlace() + " " + fabric.getAmount();
                zos.write(personData.getBytes());

                zos.closeEntry();
            }

            zos.close();
            fos.close();
            System.out.println("Data has been archived to " + zipFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
