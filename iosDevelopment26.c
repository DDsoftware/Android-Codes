import UIKit

class DrawExamples: UIView {

� � override func drawRect(rect: CGRect) {
� � � � let context = UIGraphicsGetCurrentContext()
�� � � �
� � � � let buckysFace = UIImage(named: "bucky.jpg")
� � � � let logoImage = UIImage(named: "logo.png")
�� � � �
� � � � // Draw normal
� � � � // let location = CGPointMake(25, 25)
� � � � // buckysFace?.drawAtPoint(location)
�� � � �
� � � � // Fill the screen
� � � � let entireScreen = UIScreen.mainScreen().bounds
� � � � logoImage?.drawInRect(entireScreen)
� � }

}