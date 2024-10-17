package construcao_software.ingresso_back.domain.entities;

public class TenantEntity {
    
    private Long id;
    private String name;
    private String contactInformation;
    private String specificConfigurations;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return this.contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getSpecificConfigurations() {
        return this.specificConfigurations;
    }

    public void setSpecificConfigurations(String specificConfigurations) {
        this.specificConfigurations = specificConfigurations;
    }

}
