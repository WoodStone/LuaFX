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
        Gui.makeNode("pane", "potet", pane)
        Gui.addChild("root", "potet")
        Gui.setStyle("potet", "-fx-background-color: #FF0000; -fx-border-color: #000000;")
        Gui.setStyle("root", "-fx-background-color: #00FF00;")
    end

    while true do
        jorda = os.pullEvent()
        Gui.removeChild("root", jorda['id'])
    end

    wtf()

end

function wtf()
    print('12345')
end

potet()