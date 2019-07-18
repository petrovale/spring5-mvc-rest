package guru.springfamework.controllers.v1;

import guru.springframework.model.CustomerDTO;
import guru.springfamework.services.CustomerService;
import guru.springframework.model.CustomerListDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static guru.springfamework.controllers.v1.CustomerController.BASE_URL;

@RestController
@RequestMapping(BASE_URL)
@Api("This is my Customer Controller")
public class CustomerController {

  public static final String BASE_URL = "/api/v1/customers";

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @ApiOperation(value = "This will get a list of customers.", notes = "These are some notes about the API.")
  public CustomerListDTO getListofCustomers(){
    CustomerListDTO customerListDTO = new CustomerListDTO();
    customerListDTO.getCustomers().addAll(customerService.getAllCustomers());
    return customerListDTO;
  }

  @GetMapping({"/{id}"})
  @ResponseStatus(HttpStatus.OK)
  public CustomerDTO getCustomerById(@PathVariable Long id){
    return customerService.getCustomerById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO){
    return customerService.createNewCustomer(customerDTO);
  }

  @PutMapping({"/{id}"})
  @ResponseStatus(HttpStatus.OK)
  public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
    return customerService.saveCustomerByDTO(id, customerDTO);
  }

  @PatchMapping({"/{id}"})
  @ResponseStatus(HttpStatus.OK)
  public CustomerDTO patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
    return customerService.patchCustomer(id, customerDTO);
  }

  @DeleteMapping({"/{id}"})
  @ResponseStatus(HttpStatus.OK)
  public void deleteCustomer(@PathVariable Long id) {

    customerService.deleteCustomerById(id);
  }
}
