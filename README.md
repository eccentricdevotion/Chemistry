# Chemistry

The periodic table, elements, compounds and cool sciencey things in Minecraft. This is a port / copy of the _Minecraft Education Edition Chemistry_ features to a Spigot / Paper plugin.

Requires a resource pack (included in the plugin) for best use.

### Elements creative inventory

| _GUI name:_    | Atomic elements |
| -------------: | ------------- |
| _command:_     | `/chemistry [elements\|compounds\|products\|lab]` |
| _permission:_  | `chemistry.creative` |
| _block:_       | white_glazed_terracotta |
| _block / item / GUI name:_ | Atomic elements |
| _crafting:_    | ![Atomic elements](/docs/atomic_elements.png "Atomic elements") |
| _use:_         | Click an element to add it to your inventory. Shift-click to add a stack of 64. |

### Elements constructor

| _GUI name:_    | Element constructor |
| -------------: | ------------- |
| _command:_     | `/construct`  |
| _permission:_  | `construct.build` |
| _block:_       | light_blue_glazed_terracotta |
| _block / item / GUI name:_ | Element constructor |
| _crafting:_    | ![Element constructor](/docs/element_constructor.png "Element constructor") |
| _use:_         | Click the plus (+) and minus (-) buttons to increase and decrease the number of protons, neutrons and electrons. Valid combinations will result in an element appearing. |

### Compounds GUI

| _GUI name:_    | Chemical compounds |
| -------------: | ------------- |
| _command:_     | `/compounds`  |
| _permission:_  | `compounds.create` |
| _block:_       | orange_glazed_terracotta |
| _block / item / GUI name:_ | Chemical compounds |
| _crafting:_    | ![Chemical compounds](/docs/chemical_compounds.png "Chemical compounds") |
| _use:_         | Arrange elements (left to right) in the correct amounts starting in the bottom left slot. Follow the formula for the chemical compound you are trying to create e.g. to make water the formula is _H2O_ so the first slot will have 2 hydrogen and the next slot will have 1 oxygen. Click the "Check compound" button to check the formula and combine your elements into the new compound. |

### Reduction GUI

| _GUI name:_    | Material reduction |
| -------------: | ------------- |
| _command:_     | `/reduce`     |
| _permission:_  | `reducer.use` |
| _block:_       | magenta_glazed_terracotta |
| _block / item / GUI name:_ | Material reducer |
| _crafting:_    | ![Material reducer](/docs/material_reducer.png "Material reducer") |
| _use:_         | Place a raw block into the top left slot of the GUI. Click the "Reduce" button to break the block into its atomic elements. |

### Lab table GUI

| _GUI name:_    | Lab table |
| -------------: | ------------- |
| _command:_     | `/lab`        |
| _permission:_  | `lab.combine` |
| _block:_       | yellow_glazed_terracotta |
| _block / item / GUI name:_ | Lab table |
| _crafting:_    | ![Lab table](/docs/lab_table.png "Lab table") |
| _use:_         | Arrange compounds and elements (left to right) starting in the bottom left slot. Follow the formula for the product you are trying to create e.g. to make 'Super Fertiliser' the first slot will have 1 Ammonia compound and the next slot will have 1 Phosphorus. Click the "Check product" button to check the formula and combine your ingredients into the new product. |

### Product crafting

| _GUI name:_    | Product crafting |
| -------------: | ------------- |
| _command:_     | `/products`   |
| _permission:_  | `products.craft` |
| _block:_       | lime_glazed_terracotta |
| _block / item / GUI name:_ | Product crafting |
| _crafting:_    | ![Product crafting](/docs/product_crafting.png "Product crafting") |
| _use:_         | Place ingredients into the 9 slots on the left of the GUI. Click the "Craft" button to generate the product. Ingredients will be consumed. |

### Formulas

|   |   |
| -------------: | ------------- |
| _command:_     | `/formula [compound\|product]` |
| _permission:_  | `formula.show` |
| _use:_         | Use tab completion to select the compound or product you want to see the formula for.

### Permission to open GUIs by command

|   |   |
| -------------: | ------------- |
| _permission:_     | `chemistry.command` |
| _use:_         | Allow a player to open Chemistry GUIs by command.
