package uff.ic.swlab.dataset_ertd.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import uff.ic.swlab.commons.util.SWLabHost;

public class Config {

    private SWLabHost host;

    private String rawDataRootDir;
    private String rdfRootDir;

    private String fusekiDataset;
    private String datasetname;
    private String ontologyname;

    private String localOntologyHomepageName;
    private String localOntologyname;
    private String localDatasetHomepageName;
    private String localXMLDumpName;
    private String localTurtleDumpName;
    private String localJsonldDumpName;
    private String localNtriplesDumpName;

    private static String usename;
    private static String password;

    private String remoteOntologyHomepageName;
    private String remoteOntologyName;
    private String remoteDatasetHomepageName;
    private String remoteXmlDumpName;
    private String remoteTurtleDumpName;
    private String remoteJsonldDumpName;
    private String remoteNtriplesDumpName;

    private String fusekiDataUrl;

    private Config() {
        try (InputStream input = new FileInputStream("./conf/auth.properties");) {
            Properties prop = new Properties();
            prop.load(input);

            usename = prop.getProperty("username");
            password = prop.getProperty("password");

            String _host = prop.getProperty("host", "alternate");
            if (_host == null)
                host = SWLabHost.ALTERNATE_HOST;
            else if (_host.toLowerCase().equals("primary"))
                host = SWLabHost.PRIMARY_HOST;
            else if (_host.toLowerCase().equals("development"))
                host = SWLabHost.DEVELOPMENT_HOST;
            else if (_host.toLowerCase().equals("alternate"))
                host = SWLabHost.ALTERNATE_HOST;
            else
                host = SWLabHost.ALTERNATE_HOST;
        } catch (Throwable t) {
            usename = "";
            password = "";
            host = SWLabHost.ALTERNATE_HOST;
        }

        rawDataRootDir = "./data/v3/raw";
        rdfRootDir = "./data/v3/rdf";

        fusekiDataset = "EntityRelatednessTestData";
        datasetname = fusekiDataset + "_v3";
        ontologyname = fusekiDataset + "_v1";

        localOntologyHomepageName = rdfRootDir + "/ontology/" + ontologyname + "/index.jsp";
        localOntologyname = rdfRootDir + "/ontology/" + ontologyname + ".rdf";
        localDatasetHomepageName = rdfRootDir + "/dataset/" + datasetname + "/index.jsp";
        localXMLDumpName = rdfRootDir + "/dataset/" + datasetname + ".rdf.gz";
        localTurtleDumpName = rdfRootDir + "/dataset/" + datasetname + ".ttl.gz";
        localJsonldDumpName = rdfRootDir + "/dataset/" + datasetname + ".json.gz";
        localNtriplesDumpName = rdfRootDir + "/dataset/" + datasetname + ".nt.gz";

        remoteOntologyHomepageName = "/tomcat/ontology/" + ontologyname + "/index.jsp";
        remoteOntologyName = "/tomcat/ontology/" + ontologyname + ".rdf";
        remoteDatasetHomepageName = "/tomcat/dataset/" + datasetname + "/index.jsp";
        remoteXmlDumpName = "/tomcat/dataset/" + datasetname + ".rdf.gz";
        remoteTurtleDumpName = "/tomcat/dataset/" + datasetname + ".ttl.gz";
        remoteJsonldDumpName = "/tomcat/dataset/" + datasetname + ".json.gz";
        remoteNtriplesDumpName = "/tomcat/dataset/" + datasetname + ".nt.gz";

        fusekiDataUrl = host.getDataURL(fusekiDataset);
    }

    private static Config config;

    public static Config getInsatnce() {
        if (config == null)
            config = new Config();
        return config;
    }

    public String rawDataRootDir() {
        return rawDataRootDir;
    }

    public String rdfRootDir() {
        return rdfRootDir;
    }

    public String fusekiDataset() {
        return fusekiDataset;
    }

    public String datasetname() {
        return datasetname;
    }

    public String ontologyname() {
        return ontologyname;
    }

    public String localOntologyHomepageName() {
        return localOntologyHomepageName;
    }

    public String localOntologyname() {
        return localOntologyname;
    }

    public String localDatasetHomepageName() {
        return localDatasetHomepageName;
    }

    public String localXMLDumpName() {
        return localXMLDumpName;
    }

    public String localTurtleDumpName() {
        return localTurtleDumpName;
    }

    public String localJsonldDumpName() {
        return localJsonldDumpName;
    }

    public String localNtriplesDumpName() {
        return localNtriplesDumpName;
    }

    public static String username() {
        return usename;
    }

    public static String password() {
        return password;
    }

    public String remoteOntologyHomepageName() {
        return remoteOntologyHomepageName;
    }

    public String remoteOntologyName() {
        return remoteOntologyName;
    }

    public String remoteDatasetHomepageName() {
        return remoteDatasetHomepageName;
    }

    public String remoteXmlDumpName() {
        return remoteXmlDumpName;
    }

    public String remoteTurtleDumpName() {
        return remoteTurtleDumpName;
    }

    public String remoteJsonldDumpName() {
        return remoteJsonldDumpName;
    }

    public String remoteNtriplesDumpName() {
        return remoteNtriplesDumpName;
    }

    public String fusekiDataUrl() {
        return fusekiDataUrl;
    }

    public SWLabHost host() {
        return host;
    }
}