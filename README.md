# HirveConfig
The library to convert config file into DOM-like tree model.

### Config file syntax
```
  keyword instruction(options)=outputVar instr2(opt1, o2, o3)=outputVar2
    childNode id(nodeID)
    childNode2 instruction(outputVar)
      node3 a(b) c(outputVar2)
```
