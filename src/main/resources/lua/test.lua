require('os')

jorda = ''

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
        print(Number.pi());
        Gui.addNode('potet', pane)
    end

    jorda = os.pullEvent()
    Gui.removeNode(jorda['id'])
    wtf()

end

function wtf()
    print('12345')
end

potet()