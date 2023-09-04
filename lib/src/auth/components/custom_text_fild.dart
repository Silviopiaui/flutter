import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

// ignore: must_be_immutable
class CustomTextFild extends StatefulWidget {
  final IconData icon;
  final String label;
  final bool isSecret;
  final List<TextInputFormatter>? inputFormatters;

  const CustomTextFild({
    key,
    required this.icon,
    required this.label,
    this.isSecret = false,
    this.inputFormatters,
  }) : super(key: key);

  @override
  State<CustomTextFild> createState() => _CustomTextFildState();
}

class _CustomTextFildState extends State<CustomTextFild> {
  bool isObscure = false;

  @override
  void initState() {
    super.initState();
    isObscure = widget.isSecret;
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.only(bottom: 15),
      child: TextFormField(
          inputFormatters: widget.inputFormatters,
          obscureText: isObscure,
          decoration: InputDecoration(
            prefixIcon: Icon(widget.icon),
            suffixIcon: widget.isSecret
                ? IconButton(
                    onPressed: () {
                      setState(() {
                        isObscure = !isObscure;
                      });
                    },
                    icon: Icon(
                        isObscure ? Icons.visibility : Icons.visibility_off))
                // ignore: dead_code
                : null,
            labelText: widget.label,
            isDense: true,
            border: OutlineInputBorder(
              borderRadius: BorderRadius.circular(18),
            ),
          )),
    );
  }
}
