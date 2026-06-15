public interface CustomerRepository {
    String findCustomerById(String id);
}
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(String id) {
        return "Customer_" + id;
    }
}
public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void printCustomerDetails(String id) {
        String customerData = customerRepository.findCustomerById(id);
        System.out.println("Fetched Details: " + customerData);
    }
}
public class DITest {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);
        service.printCustomerDetails("12345");
    }
}