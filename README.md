# HirveConfig
The library to convert config file into DOM-like tree model.

### Config file syntax
```
keyword instruction(options)=outputVar instr2(opt1, o2, o3)=outputVar2
  childNode id(nodeID)
  childNode2 instruction(outputVar)
    node3 a(b) c(outputVar2)
```

### Possibilities
- Using minimalistic style config file syntax with indent based hierarchy
- Attaching custom type object to each node
- Assigning ID to nodes and tree searching functionality
