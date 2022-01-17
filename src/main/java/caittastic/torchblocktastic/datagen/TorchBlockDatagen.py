import json
colours = {"black", "brown", "blue", "cyan", "gray", "green", "light_blue", "light_gray", "lime", "magenta", "orange", "pink", "purple", "red", "white", "yellow"}

for cycle in colours:
    #ITEM MODEL
    itemModelName = cycle+"_torch_block.json"
    itemModelData = '''{"parent": "torchblocktastic:block/'''+cycle+'''_torch_block"}'''
    with open(r'D:\\my programs\Simply Torch Block\src\\main\\resources\\assets\\torchblocktastic\\models\\item\\'+itemModelName, "w") as f:
        f.write(json.dumps(json.loads(itemModelData), indent = 4))

    #BLOCK MODEL
    blockModelName = cycle+"_torch_block.json"
    blockModelData = '''
    {
      "parent": "block/cube_all",
      "textures": {
        "all": "torchblocktastic:block/torch_block_'''+cycle+'''"
      }
    }'''
    with open(r'D:\\my programs\Simply Torch Block\src\\main\\resources\\assets\\torchblocktastic\\models\\block\\'+blockModelName, "w") as f:
        f.write(json.dumps(json.loads(blockModelData), indent = 4))

    #BLOCK STATES
    blockstateName = cycle+"_torch_block.json"
    blockstateData = '''
    {
      "variants": {
        "": {
          "model": "torchblocktastic:block/'''+cycle+'''_torch_block"
        }
      }
    }
    '''
    with open(r'D:\\my programs\Simply Torch Block\src\\main\\resources\\assets\\torchblocktastic\blockstates\\'+blockstateName, "w") as f:
            f.write(json.dumps(json.loads(blockstateData), indent = 4))

    #LOOT TABLE
    lootTableName = cycle+"_torch_block.json"
    lootTableData = '''
    {
      "type": "minecraft:block",
      "pools": [
        {
          "rolls": 1.0,
          "entries": [
            {
              "type": "minecraft:item",
              "name": "torchblocktastic:'''+cycle+'''_torch_block"
            }
          ]
        }
      ]
    }
    '''
    with open(r'D:\\my programs\Simply Torch Block\src\\main\\resources\data\\torchblocktastic\\loot_tables\blocks\\'+lootTableName, "w") as f:
            f.write(json.dumps(json.loads(lootTableData), indent = 4))

    if cycle != "white":
        #RECIPES - 8 BLOCK
        recipeEightName = cycle+"_torch_block_eight_blocks.json"
        recipeEightData = '''
        {
        "type": "minecraft:crafting_shaped",
          "pattern": [
            "###",
            "#X#",
            "###"
          ],
          "key": {
            "#": {
              "item": "torchblocktastic:white_torch_block"
            },
            "X": {
              "item": "minecraft:'''+cycle+'''_dye"
            }
          },
          "result": {
            "item": "torchblocktastic:'''+cycle+'''_torch_block",
            "count": 8
          }
        }
        '''
        with open(r'D:\\my programs\Simply Torch Block\src\\main\\resources\data\\torchblocktastic\\recipes\\'+recipeEightName, "w") as f:
                f.write(json.dumps(json.loads(recipeEightData), indent = 4))

        #RECIPES - 1 BLOCK
        recipeOneName = cycle+"_torch_block_one_block.json"
        recipeOneData = '''
        {
          "type": "minecraft:crafting_shapeless",
          "ingredients": [
            {
              "item": "minecraft:'''+cycle+'''_dye"
            },
            {
              "item": "torchblocktastic:white_torch_block"
            }
          ],
          "result": {
            "item": "torchblocktastic:'''+cycle+'''_torch_block"
          }
        }
        '''
        with open(r'D:\\my programs\Simply Torch Block\src\\main\\resources\data\\torchblocktastic\\recipes\\'+recipeOneName, "w") as f:
                f.write(json.dumps(json.loads(recipeOneData), indent = 4))

