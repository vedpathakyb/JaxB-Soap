package com;
import java.util.Date;
import java.io.IOException;
import jakarta.xml.bind.*;
import java.io.File;

/*import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;*/

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Bean
{
	@WebMethod
	public void Mar()
	{
		JAXBContext jaxbContext = null;
		try
		{
			jaxbContext = JAXBContext.newInstance(Fruit.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			Fruit o = new Fruit();
			o.setId(1);
			o.setName("Banana");
			o.setPrice("9.99");
			jaxbMarshaller.marshal(o, new File("/home/yvedpath/NotBackedUp/fruit.xml"));
			System.out.println("File cretaed");
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}


	}
	@WebMethod
	public void UnMar()
	{
		JAXBContext jaxbContext = null;
		try
		{
			jaxbContext = JAXBContext.newInstance(Fruit.class);
			File file = new File("/home/yvedpath/NotBackedUp/fruit.xml");

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Fruit o = (Fruit) jaxbUnmarshaller.unmarshal(file);

			System.out.println(o);
			System.out.println("Object created");
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
