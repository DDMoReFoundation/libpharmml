# libPharmML

This is the version 0.7 of libPharmML. It provides a convenient
way to read, write and validate PharmML (up to version 0.8.1).


## Installation
### Prerequisites

* Java JDK 1.6 or newer
* Ant (tested with version 1.8.4)

The project has been tested and is known to work with versions 1.6 and 1.7
of the JDK. Build instructions for both environments are provided below.

### Setting up the project
If you are downloading this distribution from a git repository then
you need to first clone the project to your local machine. The remote
repository will typically tell you how to do this.

In the previous version, latest PharmML schema definitions were fetched from 
repository during the check-out process. This does not occur anymore as there
is no more class auto-generated by XSD files, and we want stable definition files.

#### Build the jars
1. Navigate to the libPharmML folder:
    cd libPharmML

2. Open the Ant script and change the values of the properties **source**
and **target** from 1.6 to 1.7.

3. Call the default ant target, jar-all:

    ant

4. As before, ensure that everything works by running the tests:

    ant run-tests
    
### Fetching libPharmML from Maven
libPharmML is available through the EBI Maven repository:
url: http://www.ebi.ac.uk/~maven/m2repo/
group: eu.ddmore.pharmml
module: libPharmML
version: 0.7-1

## Getting Started

The API should hopefully be intuitive. It can read a PharmML document,
write a DOM to a PharmML document, create a stub DOM and validate a
DOM. Below are code snippets showing the basic operations provided by the API.


### To get an instance of the API:

    ILibPharmML libPharmML = PharmMlFactory.getInstance().createLibPharmML();


### To read a DOM:

    InputStream in = new FileInputStream("examples/example3.xml")
    IPharmMLResource resource = libPharmML.createDomFromResource(in);
    in.close;
    PharmML dom = res.getDom();


### To write:

    IPharmMLResource resource = .....
    OutputStream os = new FileOutputStream(aFile);
    libPharmML.save(os, resource);
    os.close();

### To create:

    IPharmMLResource resource = libPharmML.createDom(PharmMLVersion.DEFAULT);
    PharmML dom = resource.getDom();
    ModelDefinition mdef = dom.createModelDefinition();

### To validate:

    IPharmMLResource resource = .....
    IPharmMLValidator validator = libPharmML.getValidator();
    IValidationReport rpt = validator.createValidationReport(resource);


## Implementation notes

The PharmML DOM is generated using JAXB (see https://jaxb.java.net/)
to convert the XML Schema into a set of Java classes. Each schema maps
to a separate java package. The XML Schema design uses the "Garden of
Eden" design pattern which means all elements have a simple of complex
type. JAXB creates classes for most types and some of the elements,
but often elements are defined by their type. For example to get the
content of a <Description> element you will use a class corresponding
to its type AnnotationType:

AnnotationType descn = anElement.getDescription();

Things get more complicated when we use substitution groups, which is
effectively a form of inheritance. In this case we need to use the
JAXBElement class, and then test what class to use. For example when
accessing an element of the substitution group Scalar we must do the
following to tech what was the 'inherited' class:
       
    JAXBElement<?> scalar = rhs.getScalar();
    if(scalar.getDeclaredType().equals(RealValueType.class)){
        RealValueType real = (RealValueType)scalar.getValue();
    }

Using this configuration of JAXB a choice (as defined by XML Schema)
must be determined by selecting all the possible options for null. For
example:

    Rhs rhs = lhs.getAssign();
    if(rhs.getEquation() != null){
        // do something with an equation
    }
    else if(rhs.getSymbRef() != null){
        // do something with a Symbref
    }
    
A choice might also be manually implemented within a single attribute.
One must check for the type of the returned value:

	VectorCell cell = vector.getListOfVectorCell.get(0);
	VectorCellValue value = cell.getValue();
	if(value instanceof SymbolRef){
		// do something with a Symbref
	} else if(value instanceof Scalar){
		// check for concrete Scalar type
	}

## Validation

Currently the library validates against the XML Schema
definition. Additional rules such as type checking, checking for
duplicate symbols or dangling symbol references are also
checked.

## API versions and corresponding support for PharmML

<table border=1>
	<tr>
		<th>libPharmML version</th><th>Release date</th><th>Availability</th><th>PharmML versions supported</th>
	</tr>
	<tr>
		<td>0.7-1</td><td>24/03/16</td><td>Internal</td><td>Up to 0.8.1</td>
	</tr>
	<tr>
		<td>0.3.2-b2</td><td>18/08/14</td><td>Internal</td><td>0.4, 0.3.1, 0.3, 0.2.1</td>
	</tr>
	<tr>
		<td>0.3.1-b2</td><td>04/06/14</td><td>Internal</td><td>0.3.1, 0.3, 0.2.1</td>
	</tr>
	<tr>
		<td>0.3</td><td>15/04/14</td><td>Internal</td><td>0.3, 0.2.1</td>
	</tr>
	<tr>
		<td>0.2.1</td><td>01/03/14</td><td>Public</td><td>0.2.1</td>
	</tr>
</table>

## Acknowledgements

Thanks to Mihai Glont and Raza Ali from EBML-EBI for checking the
code and build and for their helpful feedback.

## Credits

Florent Yvon.
Stuart Moodie.
Mihai Glont.

18 May 2016.

Copyright EMBL-EBI 2016.


This code is licensed under Apache V2.0. See LICENSE for more details.
