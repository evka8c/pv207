package insanebikesteam.insanebikes;

/**
 * This class was automatically generated by the data modeler tool.
 */

@javax.persistence.Entity
@org.kie.api.definition.type.Label("User")
@org.kie.api.definition.type.Description("Data Object of the User.")
public class User implements java.io.Serializable
{

   static final long serialVersionUID = 1L;

   @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "USER_ID_GENERATOR")
   @javax.persistence.Id
   @javax.persistence.SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "USER_ID_SEQ")
   @org.kie.api.definition.type.Label("User Id")
   @org.kie.api.definition.type.Description("Auto generated User Id.")
   private java.lang.Long id;

   @org.kie.api.definition.type.Label("Name")
   @org.kie.api.definition.type.Description("Name of the user.")
   private java.lang.String name;

   @org.kie.api.definition.type.Label("Email")
   @org.kie.api.definition.type.Description("Email address of the user.")
   private java.lang.String email;

   @org.kie.api.definition.type.Label("Address")
   @org.kie.api.definition.type.Description("Home (Post) address of the user.")
   private java.lang.String address;

   @org.kie.api.definition.type.Label("Phone")
   @org.kie.api.definition.type.Description("Mobile phone number of the user.")
   private java.lang.String phone;

   @org.kie.api.definition.type.Label("Active")
   @org.kie.api.definition.type.Description("Detection of active user.")
   private boolean active;

   @org.kie.api.definition.type.Label("Provided Bikes")
   @javax.persistence.OneToMany(cascade = { javax.persistence.CascadeType.ALL }, fetch = javax.persistence.FetchType.EAGER)
   @org.kie.api.definition.type.Description("List of bikes which the user provided for sharing.")
   private java.util.List<insanebikesteam.insanebikes.Bike> provided_bikes;

   @org.kie.api.definition.type.Label("Registration Code")
   @org.kie.api.definition.type.Description("Confirmation code for registration.")
   private java.lang.String registration_code;

   @org.kie.api.definition.type.Description("Date Time of registration code generation.")
   @org.kie.api.definition.type.Label("Registration Code Created")
   private java.util.Date registration_code_created;

   @org.kie.api.definition.type.Label("Locked")
   private java.lang.Boolean locked;

   @org.kie.api.definition.type.Label("Password")
   private java.lang.String password;

   @org.kie.api.definition.type.Label("Credit")
   private java.lang.Integer credit;

   @org.kie.api.definition.type.Label(value = "Firebase ID")
   private java.lang.String fbid;

   public User()
   {
   }

   public java.lang.Long getId()
   {
      return this.id;
   }

   public void setId(java.lang.Long id)
   {
      this.id = id;
   }

   public java.lang.String getName()
   {
      return this.name;
   }

   public void setName(java.lang.String name)
   {
      this.name = name;
   }

   public java.lang.String getEmail()
   {
      return this.email;
   }

   public void setEmail(java.lang.String email)
   {
      this.email = email;
   }

   public java.lang.String getAddress()
   {
      return this.address;
   }

   public void setAddress(java.lang.String address)
   {
      this.address = address;
   }

   public java.lang.String getPhone()
   {
      return this.phone;
   }

   public void setPhone(java.lang.String phone)
   {
      this.phone = phone;
   }

   public boolean isActive()
   {
      return this.active;
   }

   public void setActive(boolean active)
   {
      this.active = active;
   }

   public java.util.List<insanebikesteam.insanebikes.Bike> getProvided_bikes()
   {
      return this.provided_bikes;
   }

   public void setProvided_bikes(
         java.util.List<insanebikesteam.insanebikes.Bike> provided_bikes)
   {
      this.provided_bikes = provided_bikes;
   }

   public java.lang.String getRegistration_code()
   {
      return this.registration_code;
   }

   public void setRegistration_code(java.lang.String registration_code)
   {
      this.registration_code = registration_code;
   }

   public java.util.Date getRegistration_code_created()
   {
      return this.registration_code_created;
   }

   public void setRegistration_code_created(
         java.util.Date registration_code_created)
   {
      this.registration_code_created = registration_code_created;
   }

   public java.lang.Boolean getLocked()
   {
      return this.locked;
   }

   public void setLocked(java.lang.Boolean locked)
   {
      this.locked = locked;
   }

   public java.lang.String getPassword()
   {
      return this.password;
   }

   public void setPassword(java.lang.String password)
   {
      this.password = password;
   }

   public java.lang.Integer getCredit()
   {
      return this.credit;
   }

   public void setCredit(java.lang.Integer credit)
   {
      this.credit = credit;
   }

   public java.lang.String getFbid()
   {
      return this.fbid;
   }

   public void setFbid(java.lang.String fbid)
   {
      this.fbid = fbid;
   }

   public User(java.lang.Long id, java.lang.String name, java.lang.String email,
         java.lang.String address, java.lang.String phone, boolean active,
         java.util.List<insanebikesteam.insanebikes.Bike> provided_bikes,
         java.lang.String registration_code,
         java.util.Date registration_code_created, java.lang.Boolean locked,
         java.lang.String password, java.lang.Integer credit,
         java.lang.String fbid)
   {
      this.id = id;
      this.name = name;
      this.email = email;
      this.address = address;
      this.phone = phone;
      this.active = active;
      this.provided_bikes = provided_bikes;
      this.registration_code = registration_code;
      this.registration_code_created = registration_code_created;
      this.locked = locked;
      this.password = password;
      this.credit = credit;
      this.fbid = fbid;
   }

}