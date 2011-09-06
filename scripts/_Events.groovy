eventDefaultStart = {
    createUnitTest = { Map args = [:] ->
        def superClass
        // map unit test superclass to Spock equivalent
        switch(args["superClass"]) {
            case "ControllerUnitTestCase":
                superClass = "ControllerSpec"
                break
            case "TagLibUnitTestCase":
                superClass = "TagLibSpec"
                break
            default:
                superClass = "UnitSpec"
        }
        createArtifact name: args["name"], suffix: "${args['suffix']}Spec", type: "Spec", path: "test/unit", superClass: superClass
    }
}