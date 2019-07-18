package guru.springfamework.api.v1.mapper;

import guru.springframework.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  @Mapping(source = "firstName", target = "firstname")
  @Mapping(source = "lastName", target = "lastname")
  CustomerDTO customerToCustomerDTO(Customer customer);

  @Mapping(source = "firstname", target = "firstName")
  @Mapping(source = "lastname", target = "lastName")
  Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
