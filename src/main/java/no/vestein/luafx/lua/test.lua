require('Number')
require('Gui')
require('os')

jorda = false

local pane = {
    x = 0,
    y = 0,
    width = 100,
    height = 200
}

function potet()
    local bool = true
    if bool then
        print(bool)
        print("poteter")
        print(Number.pi());
        Gui.addNode('potet', pane)
        Gui.removeNode('potet')
        print('test')
    end

    while jorda == false do
        jorda = os.event(jorda)
    end

end

function wtf()
    print('12345')
end

potet()