import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

@Path("/fabric")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Rest {
    private static final String SECRET_KEY = "YourSecretKey123";

    @GET
    @Path("/details")
    public ArrayList<Fabric> getFabricDetails() {
        return ContainerCreator.createFabricListFromTxtFile("in_file.txt");
    }

    @POST
    @Path("/add")
    public Fabric addFabric(Fabric fabric) {
        return fabric;
    }

    @GET
    @Path("/encrypted")
    public ArrayList<String> getEncryptedData() {
        ArrayList<Fabric> fabrics = ContainerCreator.createFabricListFromTxtFile("in_file.txt");
        return ContainerCreator.createEncryptedData(fabrics, SECRET_KEY);
    }

    @GET
    @Path("/decrypted")
    public ArrayList<String> getDecryptedData() {
        ArrayList<Fabric> fabrics = ContainerCreator.createFabricListFromTxtFile("in_file.txt");
        ArrayList<String> encryptedDataList = ContainerCreator.createEncryptedData(fabrics, SECRET_KEY);
        ArrayList<String> decryptedDataList = new ArrayList<>();
        for (String encryptedData : encryptedDataList) {
            String decryptedData = EncryptionUtil.decryptData(encryptedData, SECRET_KEY);
            decryptedDataList.add(decryptedData);
        }
        return decryptedDataList;
    }

    @GET
    @Path("/map")
    public Map<String, Fabric> getFabricMapDetails() {
        ArrayList<Fabric> fabrics = ContainerCreator.createFabricListFromTxtFile("in_file.txt");
        return ContainerCreator.createFabricMap(fabrics);
    }

    @POST
    @Path("/archive")
    public String archiveData() {
        ArrayList<Fabric> fabrics = ContainerCreator.createFabricListFromTxtFile("in_file.txt");
        Archieve.createZipArchive(fabrics, "house_archive.zip");
        Archieve.createJarArchive(fabrics, "fabrics.jar");
        Archieve.convertZipToRar("house_archive.zip", "house_archive.rar");
        return "Data has been archived.";
    }

    @POST
    @Path("/xml")
    public String writeXML() {
        ArrayList<Fabric> fabrics = ContainerCreator.createFabricListFromTxtFile("in_file.txt");
        ArrayList<Fabric> xml = ContainerCreator.createFabricListFromXMLFile("in_file.xml");
        WorkWithXML.WriteInFileXML(xml, "out_file.xml");
        return "Data has been written to XML file.";
    }

    @POST
    @Path("/json")
    public String writeJSON() throws IOException {
        ArrayList<Fabric> fabrics = ContainerCreator.createFabricListFromTxtFile("in_file.txt");
        ArrayList<Fabric> json = ContainerCreator.createFabricListFromJSONFile("in_file.json");
        WorkWithJSON.WriteInFileJSON(json);
        return "Data has been written to JSON file.";
    }

    @POST
    @Path("/txt")
    public String writeTXT() {
        ArrayList<Fabric> fabrics = ContainerCreator.createFabricListFromTxtFile("in_file.txt");
        WorkWithTXT.WriteInFileTXT(fabrics);
        return "Data has been written to TXT file.";
    }
}
