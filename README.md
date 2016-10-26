# HirveConfig
The library to convert config file into DOM-like tree model.

### Config file syntax
```
keyword option(args)=outputVar option2(arg1, arg2, arg3)=outputVar2
  childNode id(nodeID)
  childNode2 opt3(outputVar)
    node3 a(b) c(outputVar2)
```

### Possibilities
- Using minimalistic style config file syntax with indent based hierarchy
- Attaching custom type object to each node
- Assigning ID to nodes and tree searching functionality

### Installing
```
git clone https://github.com/hirve/HirveConfig/
cd HirveConfig
mvn package
```

### Using
Importing
```
import com.github.hirve.config.library.Exceptions;
import com.github.hirve.config.model.*;
```

Initializing with preferences
```
String preferencesFilePathString = "config/preferences.conf";
ConfigModel<CustomType> configModel = new ConfigModel<>(preferencesFilePathString);
```

Parsing desirable config to model
```
String testConfigFilePathString = "config/testConfig.hirve";
try {
  configModel.parse(testConfigFilePathString);
} catch (Exceptions.IncorrectSyntaxException e) {
  Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, e);
}
Config<CustomType> config = configModel.getConfig();
```

Getting root node
```
ConfigNode<CustomType> root = config.getRoot();
```

Getting node by ID
```
String Id = "nodeID";
ConfigNode<CustomType> node = config.getConfigNodeById(Id);    
```
