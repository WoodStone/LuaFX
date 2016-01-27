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
        print("poteter")
        print(Number.pi());
        Gui.addNode('potet', pane)
        print('test')
    end

    while string.len(jorda) == 0 do
        jorda = os.eventBus(jorda)
        if string.len(jorda) > 0 then
            print(jorda)
        end
    end
    wtf()

end

function wtf()
    print('12345')
end

potet()