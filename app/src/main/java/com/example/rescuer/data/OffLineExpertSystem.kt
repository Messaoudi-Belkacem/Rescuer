package com.example.rescuer.data

import com.example.rescuer.data.model.Instructions
import java.util.*

class OffLineExpertSystem {

    /*fun generateInstructions(keyWords: List<String>): Instructions {
        // Define the knowledge base
        val kb = mutableMapOf<String, Boolean>()

        // Define variables
        val patient = "x"  // Constant representing a specific patient

        // Add rules to the knowledge base for common warzone injuries
        kb["GunshotWound($patient)"] = false
        kb["BlastInjury($patient) && TraumaticAmputation($patient)"] = false
        kb["BurnInjury($patient) && SevereBurns($patient)"] = false
        kb["SharpForceInjury($patient) && SevereLaceration($patient)"] = false
        kb["CrushInjury($patient) && SevereCompression($patient)"] = false

        val agenda = mutableListOf<String>()
        // Add patient symptoms to the agenda
        for (keyword in keyWords) {
            // Do something with each keyword
            println(keyword)
            agenda.add("$keyword($patient)")
        }

        // Define first aid instructions for each injury
        val firstAidInstructions = mapOf(
            "ApplyPressure($patient)" to """Apply direct pressure to the wound using a clean cloth or bandage.
        Use your palm or fingers to apply firm, even pressure to control bleeding.
        Maintain constant pressure on the wound until bleeding stops or medical help arrives.
        Avoid lifting the cloth or bandage to check the wound, as this may disrupt clot formation.
        Monitor the victim's condition closely for signs of shock, such as pale skin, rapid heartbeat, or shallow breathing.
        If the victim shows signs of shock, lay them down flat, elevate their legs slightly, and cover them with a blanket or jacket to keep them warm.
        Wait for medical help to arrive and provide relevant information about the victim's condition and the first aid measures you've taken.""",
            "ElevateInjuredArea($patient)" to """If the injury is in an extremity (arm or leg), gently raise the injured limb above the level of the heart.
        Use pillows, blankets, or other available items to support the limb in an elevated position.
        Elevating the injured area helps reduce swelling and bleeding by allowing gravity to assist in draining excess fluid away from the injury site.
        If the injury is in the head or neck, do not attempt to elevate the area.
        Instead, keep the victim lying flat and still until medical help arrives.
        Monitor the victim's condition closely for any changes, and be prepared to adjust their position if necessary.""",
            // Add instructions for other injuries
            "ApplyTourniquet($patient)" to """If the bleeding is severe and cannot be controlled by direct pressure, consider applying a tourniquet.
        Select a wide, flat band or improvised tourniquet, such as a belt or strip of cloth, that is at least an inch or two wide.
        Position the tourniquet between the wound and the body's core, several inches above the injury site. Place the tourniquet high and tight, ensuring that it is snugly wrapped around the limb but not so tight that it causes additional pain or damage.
        Secure the tourniquet in place with a knot or clasp, ensuring that it will not loosen or slip during transport. Note the time the tourniquet was applied, as this information will be important for medical personnel.
        Monitor the victim's condition closely for any changes, and be prepared to adjust the tourniquet if necessary. Wait for medical help to arrive and provide relevant information about the victim's condition and the first aid measures you've taken.""",
            "CoolBurns($patient)" to """Identify the burned area on the victim's body, noting the size and severity of the burn.
        If the burn is minor (first-degree) and covers a small area, immediately cool the burned area with cool (not cold) running water from a tap or shower.
        If running water is not available, apply cool compresses to the burn using a clean cloth soaked in cool water.
        Continue cooling the burn for at least 10 to 15 minutes to help reduce pain, swelling, and further tissue damage.
        Do not use ice or ice water to cool the burn, as this can cause additional tissue damage.
        If the burn is severe (second-degree or larger), cover the burned area loosely with a clean, dry cloth or sterile gauze to protect it from further injury.
        Do not apply any creams, ointments, or butter to the burn, as these can trap heat and increase the risk of infection.
        Monitor the victim's condition closely for any signs of shock, such as pale skin, rapid heartbeat, or shallow breathing.
        If the victim shows signs of shock, lay them down flat, elevate their legs slightly, and cover them with a blanket or jacket to keep them warm.
        Wait for medical help to arrive and provide relevant information about the victim's condition and the first aid measures you've taken.""",
            "StabilizeInjuredArea($patient)" to """Locate the injured area on the victim's body, noting its location and severity.
        If the injury involves a broken bone or joint, or if there is significant movement or deformity at the injury site, it's essential to stabilize the injured area to prevent further damage and reduce pain.
        Begin by supporting the injured limb or body part in the position in which you found it, avoiding any unnecessary movement.
        Use improvised splints, such as rolled-up newspapers, magazines, or sturdy sticks, to immobilize the injured area.
        Place the splint along the length of the injured limb, extending beyond the joint above and below the injury site.
        Secure the splint in place using bandages, cloth strips, or other available materials, ensuring that it is snug but not too tight.
        Check the injured area for any signs of circulation, such as pulse and capillary refill, to ensure that blood flow is not restricted by the splint.
        If circulation is compromised or if the victim experiences increased pain, loosen the splint slightly and reassess the position.
        Once the injured area is stabilized, keep the victim lying down and calm until medical help arrives.
        Monitor the victim's condition closely for any changes, and be prepared to adjust the splint if necessary.
        Wait for medical help to arrive and provide relevant information about the victim's condition and the first aid measures you've taken.""",
            "CheckCirculation($patient)" to """If the injury involves significant bleeding, a crushed limb, or a suspected vascular injury, it's essential to check the circulation to assess blood flow to the affected area.
        Begin by gently palpating (feeling) for pulses in the injured limb or body part.
        Common pulse points include the wrist (radial pulse), neck (carotid pulse), and groin (femoral pulse).
        Use your fingertips to apply light pressure to the pulse point, feeling for the rhythmic pulsations of blood flow.
        If you cannot detect a pulse in the injured limb, try checking another pulse point or comparing with the pulse on the uninjured side of the body.
        Additionally, observe the color and temperature of the skin in the injured area.
        Normal skin color is pink or reddish, and the skin should feel warm to the touch.
        Pale or bluish skin, cold skin temperature, or delayed capillary refill (the time it takes for color to return after pressing on the skin) may indicate poor circulation.
        If you are unable to detect a pulse or if circulation appears compromised, notify emergency services immediately and continue providing first aid while awaiting medical help.
        Keep the victim lying down and calm, and avoid unnecessary movement of the injured limb or body part.
        Reassure the victim that help is on the way, and monitor their condition closely for any changes.
        Wait for medical help to arrive and provide relevant information about the victim's condition and the first aid measures you've taken."""
        )

        // Temporary memory
        val memory = mutableMapOf<String, Boolean>()

        // Run the expert system
        val seen = mutableSetOf<String>()
        // Keep track of the conditions already processed

        while (agenda.isNotEmpty()) {
            val p = agenda.removeAt(0)
            if (p in seen) {
                continue  // Skip the condition if it has already been processed
            }
            seen.add(p)
            if (kb[p] == true) {
                println("$p is true.")
                memory[p] = true
            } else {
                println("$p is false.")
                memory[p] = false
            }

            // Check if new rules can be activated
            if (memory["GunshotWound($patient)"] == true) {
                agenda.add("ApplyPressure($patient)")
                agenda.add("ElevateInjuredArea($patient)")
            }
            // Add similar conditions for other common injuries
            if (memory["BlastInjury($patient)"] == true && memory["TraumaticAmputation($patient)"] == true) {
                agenda.add("ApplyTourniquet($patient)")
            }
            if (memory["BurnInjury($patient)"] == true && memory["SevereBurns($patient)"] == true) {
                agenda.add("CoolBurns($patient)")
            }
            if (memory["SharpForceInjury($patient)"] == true && memory["SevereLaceration($patient)"] == true) {
                agenda.add("ApplyPressure($patient)")
            }
            // Add similar conditions for other first aid measures
            if (memory["CrushInjury($patient)"] == true && memory["SevereCompression($patient)"] == true) {
                agenda.add("StabilizeInjuredArea($patient)")
                agenda.add("CheckCirculation($patient)")
            }
            // Add similar conditions for other first aid measures
        }

        // Check the final state of the memory
        println("First aid instructions:")

        val instructionList: MutableList<String> = mutableListOf()
        for ((p, value) in memory) {
            if (value) {
                val instruction = firstAidInstructions[p]
                if (instruction != null) {
                    println("$p: $instruction")
                    instructionList.add(instruction)
                } else {
                    println("No instructions found for $p")
                }
            }
        }

        return Instructions(instructionList)
    }*/

}